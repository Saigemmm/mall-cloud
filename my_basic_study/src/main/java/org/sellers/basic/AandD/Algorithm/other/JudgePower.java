package org.sellers.basic.AandD.Algorithm.other;

/**
 * 判断一个整数是否时2的乘方
 */
public class JudgePower {
    /**
     * 设定一个中间值temp=1;并让temp一直乘2，那么temp一定是2的城防，再让temp与原数做对比。
     */
    private static boolean isPowerOf2(int number) {
        int temp = 1;
        while (temp <= number) {
            if (temp == number) {
                return true;
            }
            temp *= 2;
            //temp=temp<<1; 左位移性能高于乘法。
        }
        return false;
    }

    /**
     * 所有2的乘方转为二进制数后的只有一位数是1，且是第一位
     * 所有2的乘方减1转为二进制后都是1
     * 两者做&运算的结果必定是0
     * 位与运算 & ：只有1&1=1；其他都为0；
     * 位或运算 | ：只有0|0=0；其他都为1；
     * 异或运算 ^ ：相同为0，不同为1；
     */
    private static boolean isPowerOf2Advance(int number) {
        return (number & number - 1) == 0;
    }

    /**
     * 求出一个正整数转换成二进制后的数字“1”的个数。要求性能尽可能高。
     */
    private static int getNumbersOf1(int number) {
        int arr[]=new int[10];
        return 1;
    }
}