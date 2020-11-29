package com.lyt.learn.test;

import com.lyt.common.SingleNode;
import com.lyt.learn.DeleteNthNodeFromLast;
import junit.framework.TestCase;

public class DeleteNthNodeFromLastTest extends TestCase {

    DeleteNthNodeFromLast deleter = new DeleteNthNodeFromLast();

    public void testDeleteNthFromLast1() {
        SingleNode head = getA2F();
        SingleNode res = deleter.deleteNthFromLast(head, 1);

        SingleNode nodeA1 = new SingleNode("A");
        SingleNode nodeB1 = new SingleNode("B");
        SingleNode nodeC1 = new SingleNode("C");
        SingleNode nodeD1 = new SingleNode("D");
        SingleNode nodeE1 = new SingleNode("E");
        nodeA1.next = nodeB1;
        nodeB1.next = nodeC1;
        nodeC1.next = nodeD1;
        nodeD1.next = nodeE1;

        assertEquals(res, nodeA1);
    }

    public void testDeleteNthFromLast2() {
        SingleNode head = getA2F();
        SingleNode res = deleter.deleteNthFromLast(head, 0);
        assertEquals(res, getA2F());
    }

    public void testDeleteNthFromLast3() {
        SingleNode nodeA1 = new SingleNode("A");
        SingleNode res = deleter.deleteNthFromLast(nodeA1, 1);

        assertNull(res);
    }

    public void testDeleteNthFromLast4() {
        SingleNode head = getA2F();
        SingleNode res = deleter.deleteNthFromLast(head, 3);

        SingleNode nodeA1 = new SingleNode("A");
        SingleNode nodeB1 = new SingleNode("B");
        SingleNode nodeC1 = new SingleNode("C");

        SingleNode nodeE1 = new SingleNode("E");
        SingleNode nodeF1 = new SingleNode("F");
        nodeA1.next = nodeB1;
        nodeB1.next = nodeC1;
        nodeC1.next = nodeE1;
        nodeE1.next = nodeF1;

        assertEquals(res, nodeA1);
    }

    public void testDeleteNthFromLast5() {
        SingleNode nodeA1 = new SingleNode("A");
        nodeA1.next = new SingleNode("B");
        SingleNode res = deleter.deleteNthFromLast(nodeA1, 2);

        assertEquals(res, new SingleNode("B"));
    }

    private SingleNode getA2F() {
        SingleNode nodeA1 = new SingleNode("A");
        SingleNode nodeB1 = new SingleNode("B");
        SingleNode nodeC1 = new SingleNode("C");
        SingleNode nodeD1 = new SingleNode("D");
        SingleNode nodeE1 = new SingleNode("E");
        SingleNode nodeF1 = new SingleNode("F");
        nodeA1.next = nodeB1;
        nodeB1.next = nodeC1;
        nodeC1.next = nodeD1;
        nodeD1.next = nodeE1;
        nodeE1.next = nodeF1;
        return nodeA1;
    }
}