package org.sellers.basic.AandD.Algorithm.other;

import java.util.HashMap;

/**
 * 动态规划
 * 1:最优子结构、边界、状态转移公式
 * <p>
 * 题目1：有10个台阶的楼梯，从下往上走，每一步只能跨一级台阶或两级台阶，总共的走法。
 */
public class DynamicProgram {
    /**
     * 参数n为楼梯的台阶数
     * 10级台阶的走法等于0到9级的走法加上0到8级的走法。即F(10)=F(9)+F(8)
     * 递归算法
     * 时间复杂度O(2^n)
     */
    private static int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getClimbingWays(n - 1) + getClimbingWays(n - 2);
    }

    /**
     * 备忘录算法；
     * 对上一个算法的优化；
     * 使用缓存，将每次不同的计算结果存入map，当遇到相同参数时再从map中取出，避免了重复运算。
     * 时间复杂度O(N),空间复杂度O(N)
     *
     * @param n
     * @param map
     * @return
     */
    private static int getClimbingWaysNote(int n, HashMap<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        /**
         * map可看成备忘录，当计算F(N)时先看Map中是否存在，存在直接取，不存在计算后存入。
         * 原理：F(N)=F(N-1)+F(N-2);
         */
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = getClimbingWaysNote(n - 1, map) + getClimbingWaysNote(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 动态规划的真正模式
     * 迭代算法，每一次迭代中，只需要保留之前的两个状态；根据公式F(N)=F(N-1)+F(N-2)
     * 时间复杂度O(N)
     */
    private static int getClimbingWaysAdvance(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;//可看作旧 第一个的值
        int b = 2;//可看作旧第二个的值
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
