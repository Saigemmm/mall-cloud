package org.sellers.basic.AandD.DataStructure.Linked;

/**
 * 循环双链表
 */
public class DoubleLoopNode {

    private Object data;

    //pre pointer
    private DoubleLoopNode pre = this;

    //next  pointer
    private DoubleLoopNode next = this;

    public DoubleLoopNode(Object data) {
        this.data = data;
    }

    //增加节点
    public void afterInsert(DoubleLoopNode node) {
        //当前节点的下一个节点（当下节）
        DoubleLoopNode nextNext = this.next;
        //新节点作为当前节点的next
        this.next = node;
        //当前节点作为新节点的pre
        node.pre = this;
        //新节点作为当下节的pre
        nextNext.pre = node;
        //当下节作为新节点的next
        node.next = nextNext;
    }

    //删除当前节点的下一个节点 因为循环链表，所以不会为空
    public void removeNext() {
        this.next = this.next.next;
        this.next.next.pre = this;
        DoubleLoopNode nextNode = this.next;
        nextNode.next = null;
        nextNode.pre = null;
    }

    public DoubleLoopNode getPre() {
        return this.pre;
    }

    public DoubleLoopNode getNext() {
        return this.next;
    }

    public Object getData() {
        return this.data;
    }
}
