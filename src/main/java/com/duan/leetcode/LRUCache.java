//package com.duan.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LRUCache<K, V> {
//    private final Map<K, Node<K, V>> map;
//    private final int capacity;
//    private Node<K, V> head = null;
//    private Node<K, V> tail = null;
//
//    public LRUCache(int capacity) {
//        this.map = new HashMap<>();
//        this.capacity = capacity;
//    }
//
//    public V get(K key) {
//        if(!map.containsKey(key)) {
//            return null;
//        }
//
//        Node<K, V> kvNode = map.get(key);
//        // 从列表中删除
//        // 移动到列表的前面
//        return kvNode.value;
//    }
//
//    public V put(K key, V value) {
//        if(!map.containsKey(key)) {
//            if(map.size() > this.capacity) {
//                // 删除末尾的节点
//            }
//            Node<K, V> node = new Node<>(key, value);
//            map.put(key, node);
//            // 将节点放在列表前面
//            return null;
//        }
//        Node<K, V> oldNode = map.get(key);
//        V oldValue = oldNode.value;
//        oldNode.value = value;
//        // 从列表中删除
//        // 移动到列表前面
//        return oldValue;
//    }
//}
//
//class Node<K, V> {
//    K key;
//    V value;
//
//    Node prev;
//    Node next;
//
//    public Node() {}
//
//    public Node(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//}
