package com.lyt.learn;

import com.lyt.common.SingleNode;

public class FindMidInLinkedList {
    public SingleNode getMid(SingleNode head) {
        if (head == null) {
            return null;
        }

        SingleNode nullNode = new SingleNode(null);
        nullNode.next = head;

        SingleNode a1 = nullNode;
        SingleNode a2 = nullNode;
        while (a2 != null) {
            // if a2.next==null but a2 is not null, we should go ahead one step
            if (a2.next == null) {
                a2 = null;
            } else {
                a2 = a2.next.next;
            }
            a1 = a1.next;
        }

        return new SingleNode(a1.name);
    }
}
