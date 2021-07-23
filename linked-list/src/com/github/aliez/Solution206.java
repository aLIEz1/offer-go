package com.github.aliez;

/**
 * 206 反转链表
 *
 * @author Administrator
 * @date 2021/7/23 20:14
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode o, ListNode head) {
        if (head == null) {
            return o;
        }
        ListNode next = head.next;
        head.next = o;
        return reverse(head, next);
    }
}
