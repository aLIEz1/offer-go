package com.github.alize;

import java.util.HashMap;

/**
 * 146 LRU缓存机制
 *
 * @author Administrator
 * @date 2021/7/23 22:27
 */
public class LRUCache {
    private HashMap<Integer, Node> cache = new HashMap<>(16);
    private int capacity;
    private Node dummyHead = new Node();
    private Node dummyTail = new Node();
    private int size;

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            if (size >= capacity) {
                Node last = removeLast();
                cache.remove(last.key);
            } else {
                size++;
            }
            addFirst(newNode);
            cache.put(key, newNode);

        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void removeNow(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNow(node);
        addFirst(node);
    }

    private void addFirst(Node node) {
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        dummyHead.next = node;

    }

    private Node removeLast() {
        Node res = dummyTail.prev;
        removeNow(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
