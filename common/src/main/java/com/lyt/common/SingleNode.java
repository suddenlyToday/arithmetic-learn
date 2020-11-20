package com.lyt.common;

import java.util.Objects;

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
            res.append("null");
        }
        System.out.println(res.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleNode that = (SingleNode) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, next);
    }
}
