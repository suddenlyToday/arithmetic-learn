## dekker算法

解决进程互斥的算法。

步骤如下：

举手；
while(其他人也举手){
	if(轮到别人){
		放手；
		while(轮到别人)；// 等到轮到自己为止
		举手；
	}
}
临界区代码执行；
轮给别人；
放手；

使用java实现的过程中，遇到了如下两个问题：
1. dekker中的turn和flag数组一开始未使用volatile关键字，导致死循环；
2. 想到turn和flag数组使用volatile关键字后，仍得不到正确结果，
参看[ErrorDekker.java](src/main/java/com/lyt/learn/ErrorDekker.java)

后续需要更深刻学习一下volatile关键字。

