package com.duan.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

public class SyncPrimitive implements Watcher {

    static ZooKeeper zk = null;
    static Integer mutex;
    String root;

    SyncPrimitive(String address) {
        if (zk == null) {
            try {
                System.out.println("Starting ZK:");
                zk = new ZooKeeper(address, 3000, this);
                mutex = new Integer(-1);
                System.out.println("Finished starting ZK:" + zk);
            } catch (IOException e) {
                System.out.println(e.toString());
                zk = null;
            }
        }
    }

    @Override
    synchronized public void process(WatchedEvent event) {
        synchronized (mutex) {
            System.out.println("Process: " + event.getType());
            mutex.notify();
        }
    }

    static public class Barrier extends SyncPrimitive {
        int size;
        String name;

        Barrier(String address, String root, int size) {
            super(address);
            this.root = root;
            this.size = size;

            if (zk != null) {
                try {
                    Stat s = zk.exists(root, false);
                    if (s == null) {
                        zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    }
                } catch (KeeperException e) {
                    System.out.println("Keeper exception when instantiating queue: "
                            + e.toString());
                } catch (InterruptedException e) {
                    System.out.println("Interrupted exception");
                }
            }

            // My node name
            try {
                name = new String(InetAddress.getLocalHost().getCanonicalHostName().toString());
            } catch (UnknownHostException e) {
                System.out.println(e.toString());
            }
        }

        boolean enter() throws InterruptedException, KeeperException {
            zk.create(root + "/" + name, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            while (true) {
                synchronized (mutex) {
                    List<String> list = zk.getChildren(root, true);
                    if (list.size() < size) {
                        mutex.wait();
                    } else {
                        return true;
                    }
                }
            }
        }

        boolean leave() throws InterruptedException, KeeperException {
            zk.delete(root + "/" + name, 0);
            while (true) {
                synchronized (mutex) {
                    List<String> list = zk.getChildren(root, true);
                    if (list.size() > 0) {
                        mutex.wait();
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    static public class Queue extends SyncPrimitive {

        Queue(String address, String name) {
            super(address);
            this.root = name;
            if (zk != null) {
                try {
                    Stat s = zk.exists(root, false);
                    if (s == null) {
                        zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.toString());
                }
            }
        }

        boolean produce(int i) throws InterruptedException, KeeperException {
            ByteBuffer b = ByteBuffer.allocate(4);
            byte[] value;
            b.putInt(i);
            value = b.array();
            zk.create(root + "/element", value, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            return true;
        }

        int consume() throws InterruptedException, KeeperException {
            int retvalue = -1;
            Stat stat = null;
            while (true) {
                synchronized (mutex) {
                    List<String> list = zk.getChildren(root, true);
                    if (list.size() == 0) {
                        mutex.wait();
                    } else {
                        Integer min = new Integer(list.get(0).substring(7));
                        String minNode = list.get(0);
                        for (String s : list) {
                            Integer tempValue = new Integer(s.substring(7));
                            //System.out.println("Temporary value: " + tempValue);
                            if (tempValue < min) {
                                min = tempValue;
                                minNode = s;
                            }
                        }
                        System.out.println("Temporary value: " + root + "/" + minNode);
                        byte[] b = zk.getData(root + "/" + minNode,
                                false, stat);
                        zk.delete(root + "/" + minNode, 0);
                        ByteBuffer buffer = ByteBuffer.wrap(b);
                        retvalue = buffer.getInt();

                        return retvalue;
                    }
                }
            }

        }

    }

    public static void main(String args[]) throws InterruptedException {
//        if (args[0].equals("qTest"))
//            queueTest(args);
//        else
//            barrierTest(args);

//        queueTest(new String[]{"", "localhost:2181", "200", "p"});
        queueTest(new String[]{"", "localhost:2181", "100", "c"});
    }

    public static void queueTest(String args[]) throws InterruptedException {
        Queue q = new Queue(args[1], "/app1");

        System.out.println("Input: " + args[1]);
        int i;
        Integer max = new Integer(args[2]);

        if (args[3].equals("p")) {
            System.out.println("Producer");
            for (i = 0; i < max; i++)
                try {
                    q.produce(10 + i);
                } catch (KeeperException e) {

                } catch (InterruptedException e) {

                }
        } else {
            System.out.println("Consumer");

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < max; i++) {
                        try {
                            int r = q.consume();
                            System.out.println("1 - Item: " + r);
                        } catch (KeeperException e) {
                            i--;
                        } catch (InterruptedException e) {
                        }
                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < max; i++) {
                        try {
                            int r = q.consume();
                            System.out.println("2 - Item: " + r);
                        } catch (KeeperException e) {
                            i--;
                        } catch (InterruptedException e) {
                        }
                    }
                }
            });
            t2.start();

            t1.join();
            t2.join();
        }
    }

    public static void barrierTest(String args[]) {
        Barrier b = new Barrier(args[1], "/b1", new Integer(args[2]));
        try {
            boolean flag = b.enter();
            System.out.println("Entered barrier: " + args[2]);
            if (!flag) System.out.println("Error when entering the barrier");
        } catch (KeeperException e) {
        } catch (InterruptedException e) {
        }

        // Generate random integer
        Random rand = new Random();
        int r = rand.nextInt(100);
        // Loop for rand iterations
        for (int i = 0; i < r; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        try {
            b.leave();
        } catch (KeeperException e) {

        } catch (InterruptedException e) {

        }
        System.out.println("Left barrier");
    }
}
