package org.sellers.basic.AandD.Algorithm.recursive;


public class Febonacci {
    //Febonacci数列，前两项为1，从第三项开始的每一项都等于前两项之和
    private static int febonacciSequence(int i) {
        if (i == 1)
            return 1;
        else if (i == 2)
            return 2;
        else
            return febonacciSequence(i - 1) + febonacciSequence(i - 2);
    }

    /**
     * 汉诺塔问题，即三个柱子上面套环，然后计算移动环从第一个柱子到第三个柱子所需的次数
     * 一次只能移动一个环，大环不能放在小环上。
     * 当环为i个时，需要移动的次数
     * 思路：用整体法。
     * 无论有多少个环，都认为只有两个。上面的所有环和最下面的一个环。（除一个外 ）
     */
    private static int hanoiTower(int i) {
        if (i == 1)
            return 1;
        else if (i == 2)
            return 3;
        else
            return hanoiTower(i - 1) + hanoiTower(i - 2);
    }
}
