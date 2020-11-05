package com.lyt.common;

public class SingleNode {
    public String name;
    public SingleNode next;

    public SingleNode(String name) {
        this.name = name;
    }

    public void printNode() {
        StringBuilder res = new StringBuilder();
        SingleNode next = this;
        while (next != null) {
            res.append(next.name).append("-->");
            next = next.next;
        }
        if (res.length() > 0) {
            res.append("-->null");
        }
        System.out.println(res.toString());
    }
}
