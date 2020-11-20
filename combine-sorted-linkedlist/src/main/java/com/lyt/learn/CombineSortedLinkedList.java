package com.lyt.learn;

import com.lyt.common.SingleNode;

public class CombineSortedLinkedList {
    public SingleNode combine(SingleNode head1, SingleNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        SingleNode a1 = null;
        SingleNode b1 = head1;

        SingleNode a2 = head2;
        SingleNode b2 = head2;

        while (b2 != null) {
            // find a node bigger than a2
            while (b1 != null && b1.name.compareTo(b2.name) <= 0) {
                a1 = b1;
                b1 = b1.next;
            }

            // b1 is null mean can not find node bigger than a2 in list1
            // means list1 all node is small than a2
            if (b1 == null) {
                a1.next = a2;
                return head1;
            }

            if (a1 == null) {
                head1 = a2;
            }

            while (b2.next != null && b2.next.name.compareTo(b1.name) <= 0) {
                b2 = b2.next;
            }

            SingleNode temp = b2.next;
            b2.next = b1;
            if (a1 != null) {
                a1.next = a2;
            }
            a2 = b2 = temp;
        }

        return head1;
    }
}
