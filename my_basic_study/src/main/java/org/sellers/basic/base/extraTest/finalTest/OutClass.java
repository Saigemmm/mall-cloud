package org.sellers.basic.base.extraTest.finalTest;

/**
 * 局部内部类和匿名内部类只能访问被final修饰的局部变量
 *
 * 也就是说被局部内部类和匿名内部类访问的变量都必须使用final修饰
 */
public class OutClass {
    private int age=12;

    //这里的x,y都没有被final修饰，但是IDEA会在编译后的class文件中自动编译成final修饰的，具体可以查看OutClass.class文件。
    //前提是在被内部类引用的变量x,y都没有被修改的前提下才会编译成功，否则报错
    public void outPrint(int x){
        int y=10;
        //局部内部类
        class InClass{
            public void InPrint(){
                System.out.println(x);
                System.out.println(age);
                System.out.println(y);
            }
        }
        //y=13;//此处若放开这段注解，则会报错，因为y被内部类引用，所以默认被加上了final修饰符；x同理
        new InClass().InPrint();
        age=14;//此处比较神奇，可以查看OutClass.class文件知晓原理
    }

    public static void main(String[] args) {
        new OutClass().outPrint(11);
    }
}
