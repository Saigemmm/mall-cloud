package org.sellers.basic.AandD.DataStructure;

import org.sellers.basic.AandD.DataStructure.Queue.LinkedQueue;

public class DataStructureTest {

    public static void main(String[] args) {
//        int index=ArrayBinarySearch.binarySearch(new int[]{1,2,3,4,5,6,7,8,9},10);
//        System.out.println(index);
        //arrayList
//        ArrayObjects arrayObjects=new ArrayObjects();
//        arrayObjects.add(10);
//        arrayObjects.add("aaa");
//        arrayObjects.add("bbb");
//        arrayObjects.add("ccc",2);
//        arrayObjects.delete(2);
//        System.out.println(arrayObjects.get(2));
        //stack
//        StackOfArray stack=new StackOfArray();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        int element=stack.pop();
//        stack.pop();
//        System.out.println(element);
//        System.out.println(stack.peek());
        //queue
//        QueueOfArray queue=new QueueOfArray();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        //node
//        Node node1=new Node("aaa");
//        Node node2=new Node("bbb");
//        Node node3=new Node("ccc");
//        node1.append(node2).append(node3);
//        System.out.println(node1.getData().toString()+node1.getNext().getData());
//        System.out.println(node2.getData().toString()+node1.getNext().getNext().getData());
//        node1.show();
//        node2.removeNext();
//        node1.show();
//        node1.afterInsert(new Node("ddd"));
//        node1.show();
        //loopNode
//        LoopNode loopNode1=new LoopNode("aaa");
//        LoopNode loopNode2=new LoopNode("bbb");
//        LoopNode loopNode3=new LoopNode("ccc");
//        loopNode1.afterInsert(loopNode2);
//        loopNode2.afterInsert(loopNode3);
//        System.out.println(loopNode1.getNext().getNext().getNext().getData());
//        loopNode2.removeNext();
//        System.out.println(loopNode2.getNext().getData());
        //doubleLoopNode
//        DoubleLoopNode doubleLoopNode1=new DoubleLoopNode("aaa");
//        DoubleLoopNode doubleLoopNode2=new DoubleLoopNode("bbb");
//        DoubleLoopNode doubleLoopNode3=new DoubleLoopNode("ccc");
//        doubleLoopNode1.afterInsert(doubleLoopNode2);
//        System.out.println(doubleLoopNode1.getPre().getData());
//        System.out.println(doubleLoopNode1.getData());
//        System.out.println(doubleLoopNode1.getNext().getData());
//        doubleLoopNode1.afterInsert(doubleLoopNode3);
//        System.out.println(doubleLoopNode1.getPre().getData());
//        System.out.println(doubleLoopNode1.getData());
//        System.out.println(doubleLoopNode1.getNext().getData());
        //linkedQueue
        LinkedQueue queue=new LinkedQueue();
        queue.add("aaa");
        System.out.println(queue.poll());
        queue.add("bbb");
        queue.add("ccc");
        queue.add("ddd");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
