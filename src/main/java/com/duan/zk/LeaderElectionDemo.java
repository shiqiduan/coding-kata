package com.duan.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class LeaderElectionDemo {
    private final CuratorFramework client;

    LeaderSelectorListener listener = new LeaderSelectorListener() {
        @Override
        public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
            System.out.println("leader now");
            for (int i = 0; i < 50; i++) {
                Thread.sleep(100);
            }
        }

        @Override
        public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
            System.out.println("connectionState: " + connectionState.name());
        }
    };

    public LeaderElectionDemo() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        this.client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();

        LeaderSelector selector = new LeaderSelector(client, "/app02/ele", listener);
        selector.autoRequeue();
        selector.start();
    }

    public static void main(String[] args) throws InterruptedException {
        LeaderElectionDemo demo = new LeaderElectionDemo();

        Thread.sleep(20 * 1000);
    }
}
