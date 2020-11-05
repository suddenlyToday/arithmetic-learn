package com.lyt.learn;

import com.lyt.common.SingleNode;

public class ReverseLinkedList {
    public SingleNode reverseLinkedList(SingleNode head) {
        SingleNode next = null;
        SingleNode cur = head;
        SingleNode prev = null;
        while (cur != null) {
            prev = cur.next;
            cur.next = next;
            next = cur;
            cur = prev;
        }
        head = next;
        return head;
    }
}
