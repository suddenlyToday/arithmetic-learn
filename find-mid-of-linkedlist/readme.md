## 找到链表中间节点

举例：
1->2->3->4->5  find 3
1->2->3->4 find 3

方法很简单，两个指针，a1每次走一步，a2每次走两步，当a2为null时，a1就走到了中间位置。