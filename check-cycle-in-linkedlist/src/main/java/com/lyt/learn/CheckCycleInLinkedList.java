package com.lyt.learn;

import com.lyt.common.SingleNode;

public class CheckCycleInLinkedList {
    public boolean hasCycle(SingleNode head) {
        if (head == null) {
            return false;
        }

        SingleNode fast = head;
        SingleNode slow = head;

        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
