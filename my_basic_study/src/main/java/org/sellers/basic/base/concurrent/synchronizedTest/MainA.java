package org.sellers.basic.base.concurrent.synchronizedTest;

import java.util.concurrent.atomic.AtomicInteger;

public class MainA {

    public int anInt=0;

    AtomicInteger atomicInteger=new AtomicInteger();

    public void increase() {
        //悲观锁
        /*synchronized (LockTest.class) {
            anInt++;
        }*/
        //CAS
        atomicInteger.incrementAndGet();
        //上一行内部逻辑
        while (true){
            int oldValue=atomicInteger.get();
            int newValue=oldValue+1;
            if(atomicInteger.compareAndSet(oldValue,newValue))//CAS
                break;
        }
    }


    /*private static synchronized void increase() {
        anInt++;
    }*/

    public long getAnInt(){
        return atomicInteger.get();
    }
}
