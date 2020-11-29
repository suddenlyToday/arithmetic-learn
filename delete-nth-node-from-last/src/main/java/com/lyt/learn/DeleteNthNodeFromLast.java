package com.lyt.learn;

import com.lyt.common.SingleNode;

public class DeleteNthNodeFromLast {
    public SingleNode deleteNthFromLast(SingleNode head, int n) {
        SingleNode nodeNull = new SingleNode(null);
        nodeNull.next = head;

        SingleNode prev1 = nodeNull;
        SingleNode prev2 = nodeNull;

        //there should be n nodes between node 1 and node 2
        int step = 0;
        while (prev1 != null && step <= n) {
            prev1 = prev1.next;
            step++;
        }

        // the linked list does not have n node totally
        if (step < n) {
            return head;
        }

        while (prev1 != null) {
            prev1 = prev1.next;
            prev2 = prev2.next;
        }
        if (prev2 != null && prev2.next != null) {
            prev2.next = prev2.next.next;
        }
        return nodeNull.next;
    }
}
