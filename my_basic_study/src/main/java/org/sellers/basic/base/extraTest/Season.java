package org.sellers.basic.base.extraTest;

public enum Season {
    SPRING("春天",""),//每一个枚举即调用一次构造方法
    SUMMER("夏天",""),
    AUTUMN("秋天",""),
    WINTER("冬天","");

    private final String name;//每定义一个参数即需要在构造中添加上
    private final String desc;

    Season(String name,String desc) {
        this.name=name;
        this.desc=desc;
    }

    public void showInfo(){
        System.out.println(this.name+this.desc);
    }

}
