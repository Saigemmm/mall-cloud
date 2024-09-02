package org.sellers.basic.AandD.Algorithm.leecode;

/**
 * 1. 有两个等长数组A,B；长度都为N
 * 2. A[i]只可以选择和B[i]交换，0<=i<N
 * 3. 你的目的是让A有序，返回能不能做到
 * <p>
 * 此处假设按判断按升序排序，降序同理
 */
public class LetASorted {
    public boolean canSorted(int[] A, int[] B) {
        return process(A, B, 0, Integer.MIN_VALUE);
    }

    /**
     * 假设已经扫描过的部分：A[0...index-1]已经过去即有序了，能否保证A[index...最后]也有序
     *
     * @param A
     * @param B
     * @param index 从左到右遍历的下标
     * @param pre   前一个下标A或B中的的最大数
     */
    private boolean process(int[] A, int[] B, int index, int pre) {
        if (index == A.length) {
            return true;
        }
        //index还没有到终止位置
        //此时假设两种情况：（1）A[index]和B[index]不交换。 （2）A[index]和B[index]交换
        //只要两者有一个成功则表示该数组能够被交换成有序
        boolean p1 = pre > A[index] ? false : process(A, B, index + 1, A[index]);
        boolean p2 = pre > B[index] ? false : process(A, B, index + 1, B[index]);
        return p1 | p2;
    }

    private boolean processDynamic(int[] A, int[] B) {
        int pre = Math.min(A[0], B[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= pre && B[i] >= pre) {
                pre = Math.min(A[i], B[i]);
            } else if (A[i] >= pre && B[i] < pre) {
                pre = A[i];
            } else if (A[i] < pre && B[i] >= pre) {
                pre = B[i];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LetASorted letASorted=new LetASorted();
        boolean b = letASorted.processDynamic(new int[]{8, 4,3,10}, new int[]{4, 3,1,1});
        System.out.println(b);
    }
}
