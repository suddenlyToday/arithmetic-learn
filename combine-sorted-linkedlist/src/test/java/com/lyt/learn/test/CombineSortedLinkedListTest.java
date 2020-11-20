package com.lyt.learn.test;

import com.lyt.common.SingleNode;
import com.lyt.learn.CombineSortedLinkedList;
import junit.framework.TestCase;
import org.junit.Assert;

public class CombineSortedLinkedListTest extends TestCase {
    private CombineSortedLinkedList merger = new CombineSortedLinkedList();

    public void testCombine1() {
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeC = new SingleNode("C");
        SingleNode nodeE = new SingleNode("E");
        nodeA.next = nodeC;
        nodeC.next = nodeE;

        nodeA.printNode();
        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeD = new SingleNode("D");
        SingleNode nodeF = new SingleNode("F");
        nodeB.next = nodeD;
        nodeD.next = nodeF;
        nodeB.printNode();

        SingleNode nodeA1 = getA2F();

        SingleNode res = merger.combine(nodeA, nodeB);
        res.printNode();
        Assert.assertEquals(res, nodeA1);
    }

    public void testCombine2() {
        SingleNode nodeA = getA2F();

        SingleNode nodeG = new SingleNode("G");

        SingleNode nodeA1 = new SingleNode("A");
        SingleNode nodeB1 = new SingleNode("B");
        SingleNode nodeC1 = new SingleNode("C");
        SingleNode nodeD1 = new SingleNode("D");
        SingleNode nodeE1 = new SingleNode("E");
        SingleNode nodeF1 = new SingleNode("F");
        SingleNode nodeG1 = new SingleNode("G");
        nodeA1.next = nodeB1;
        nodeB1.next = nodeC1;
        nodeC1.next = nodeD1;
        nodeD1.next = nodeE1;
        nodeE1.next = nodeF1;
        nodeF1.next = nodeG1;

        Assert.assertEquals(merger.combine(nodeA, nodeG), nodeA1);
    }

    public void testCombine3() {
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeC = new SingleNode("C");
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        SingleNode nodeD = new SingleNode("D");
        SingleNode nodeE = new SingleNode("E");
        SingleNode nodeF = new SingleNode("F");
        nodeD.next = nodeE;
        nodeE.next = nodeF;

        SingleNode nodeA1 = getA2F();

        SingleNode res = merger.combine(nodeD, nodeA);
        Assert.assertEquals(res, nodeA1);
    }

    public void testCombine4() {
        SingleNode nodeA = new SingleNode("A");

        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeC = new SingleNode("C");
        SingleNode nodeD = new SingleNode("D");
        SingleNode nodeE = new SingleNode("E");
        SingleNode nodeF = new SingleNode("F");
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;

        SingleNode nodeA1 = getA2F();

        Assert.assertEquals(merger.combine(nodeA, nodeB), nodeA1);
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