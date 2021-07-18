package com.github.aliez;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Administrator
 * @date 2021/7/18 9:11
 */
public class CQueue {
    private Deque<Integer> in = new ArrayDeque<>();
    private Deque<Integer> out = new ArrayDeque<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
            return out.pop();
        }
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        if (out.isEmpty()) {
            return -1;
        }
        return out.pop();
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
    }
}
