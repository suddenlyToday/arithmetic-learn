package com.lyt.learn.test;

import com.lyt.common.SingleNode;
import com.lyt.learn.ReverseLinkedList;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListTest extends TestCase {

    ReverseLinkedList test = new ReverseLinkedList();

    public void testReverseLinkedList() {
        SingleNode node1 = new SingleNode("1");
        SingleNode node2 = new SingleNode("2");
        SingleNode node3 = new SingleNode("3");
        SingleNode node4 = new SingleNode("4");
        SingleNode node5 = new SingleNode("5");
        SingleNode node6 = new SingleNode("6");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        List<String> listBeforeReverse = linkedList2List(node1);

        node1.printNode();
        node1 = test.reverseLinkedList(node1);
        node1.printNode();

        List<String> listAfterReverse = linkedList2List(node1);

        int size = listBeforeReverse.size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(listBeforeReverse.get(i), listAfterReverse.get(size - i - 1));
        }
    }

    private List<String> linkedList2List(SingleNode head) {
        List<String> res= new ArrayList<>();
        while (head != null) {
            res.add(head.name);
            head = head.next;
        }
        return res;
    }
}