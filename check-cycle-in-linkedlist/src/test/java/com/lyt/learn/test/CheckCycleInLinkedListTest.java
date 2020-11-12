package com.lyt.learn.test;

import com.lyt.common.SingleNode;
import com.lyt.learn.CheckCycleInLinkedList;
import junit.framework.TestCase;
import org.junit.Assert;

public class CheckCycleInLinkedListTest extends TestCase {
private CheckCycleInLinkedList checker = new CheckCycleInLinkedList();

    public void test1() {
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeC = new SingleNode("C");
        SingleNode nodeD = new SingleNode("D");
        SingleNode nodeE = new SingleNode("E");
        SingleNode nodeF = new SingleNode("F");
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeD;

        Assert.assertTrue(checker.hasCycle(nodeA));
    }

    public void test2() {
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeC = new SingleNode("C");
        SingleNode nodeD = new SingleNode("D");
        SingleNode nodeE = new SingleNode("E");
        SingleNode nodeF = new SingleNode("F");
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;

        Assert.assertFalse(checker.hasCycle(nodeA));
    }

    public void test3() {
        SingleNode nodeA = new SingleNode("A");

        Assert.assertFalse(checker.hasCycle(nodeA));
    }

    public void test4() {
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeB = new SingleNode("B");

        nodeA.next = nodeB;
        nodeB.next=nodeA;

        Assert.assertTrue(checker.hasCycle(nodeA));
    }

    public void test5() {
        SingleNode nodeA = new SingleNode("A");

        nodeA.next = new SingleNode("B");

        Assert.assertFalse(checker.hasCycle(nodeA));
    }
}