## 删除倒数第n个节点

1. prev1和prev2初始指向head之前的null节点；
2. prev1先向前走n+1步，若prev1未走到，说明没有n个元素，直接返回head；
3. prev1走到n+1步后，prev2与prev1一块向前走，此时prev1与prev2之前相差n个元素，当prev1走到null时，说明prev2在倒数第n+1个元素上；
4. 令prev2.next=prev2.next.next即可。