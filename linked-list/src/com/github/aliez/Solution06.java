package com.github.aliez;

import java.util.LinkedList;

/**
 * 05 从尾到头打印链表
 *
 * @author Administrator
 * @date 2021/7/18 23:14
 */
public class Solution06 {
    public int[] reversePrint1(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
