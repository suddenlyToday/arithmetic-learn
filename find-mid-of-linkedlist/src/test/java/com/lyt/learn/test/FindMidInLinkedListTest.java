package com.lyt.learn.test;

import com.lyt.common.SingleNode;
import com.lyt.learn.FindMidInLinkedList;
import junit.framework.TestCase;

public class FindMidInLinkedListTest extends TestCase {
    private FindMidInLinkedList tester = new FindMidInLinkedList();

    public void testGetMid1() {
        SingleNode mid = tester.getMid(getA2F());
        mid.printNode();
        assertEquals(mid, new SingleNode("D"));
    }

    public void testGetMid2() {
        SingleNode nodeB = getA2F().next;
        SingleNode mid = tester.getMid(nodeB);
        mid.printNode();
        assertEquals(mid, new SingleNode("D"));
    }

    public void testGetMid3() {
        SingleNode nodeA1 = new SingleNode("A");
        nodeA1.next = new SingleNode("B");
        SingleNode mid = tester.getMid(nodeA1);
        mid.printNode();
        assertEquals(mid, new SingleNode("B"));
    }

    public void testGetMid4() {
        SingleNode nodeA1 = new SingleNode("A");
        SingleNode mid = tester.getMid(nodeA1);
        mid.printNode();
        assertEquals(mid, new SingleNode("A"));
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