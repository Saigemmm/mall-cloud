package org.sellers.basic.AandD.Algorithm.sort;

import org.sellers.basic.AandD.DataStructure.Queue.ArrayQueue;

import java.util.Arrays;

public class SortAlgorithm {
    //每一轮都是相邻的前后两个数字之间的对比，即a[i]与a[i+1]之间的对比，这样每一轮都会出现一个最大的数在数组末尾
    //另类冒泡，就是将最大的数往后移动而已，和下面那种冒泡相反  这种不提倡，别看了
    public void secBubbleSort(int[] array) {
        //控制总共需要比较多少轮
        for (int i = 0; i < array.length - 1; i++) {
            //控制每一轮需要比较的次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

    //冒泡排序的正宗方式
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
    }

    /**
     * 直接插入排序
     * <p>
     * 从第二个数开始，用第二个数和他前面的一个数相比，若第二个数更小，则交换位置。
     * 然后在用交换后的第三个和第二个比，步骤同上，之后还得和第一个比较，即与它前面的所有数字都需要比较
     * 往后依次类推。
     * <p>做法：
     * 相当于手动创建一个基准下标，从这个下标往左的所有数字都是已排序好的，一开始基准下标为0
     * 从i=1开始for循环，并把array[i]赋值给临时变量temp
     * 从i开始往前遍历，即从j（j=i-1）开始 第二个for循环，且array[j]要大于temp
     * 若符合条件则将j所在的值前移一位
     * 直至不符合条件，将temp赋值给j+1
     */
    public void directInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i];
                int j;
                for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    /**
     * 选择排序
     * 第一轮，默认a[0]是最小的数字，然后依次往后找，将最小的数字放到最前面，
     * 后面N轮都是如此
     */
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 最重要的：
     * 快速排序：
     * 通常找第一个数为基准数，第一个数为低位指针，最后一个数为高位指针。
     * 高位指针元素与基准数比较大小，若比基准数更大，则高位指针向中间移一位；若更小，则将高位指针元素赋值给低位指针
     * 此时开始比较低位指针元素与基准数大小，若比基准数更小，则低位指针向中间移一位；若更大，则将低位指针元素赋值给高位指针
     * 如此往复；直至低位指针与高位指针重合。
     * 即保证低位指针所指到过的数都要比基准数小；高位反之
     * 最后以指针为分界点如上如此递归。
     *
     * @param array 需要排序的数组
     * @param start 排序的起始位置，0
     * @param end   结束位置，array.length-1
     */
    public void quickSort(int[] array, int start, int end) {
        if (start < end) {
            //基准数
            int standard = array[start];
            //低位指针
            int low = start;
            //高位指针
            int high = end;
            while (low < high) {
                while (low < high && array[high] > standard) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] < standard) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = standard;
            quickSort(array, start, low);
            quickSort(array, low + 1, end);
        }
    }

    /**
     * 归并排序
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 递归阶段
     */
    public void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    /**
     * 归并排序的切割合并部分
     * 将数组无线分割成不可在分的的小数组，即每个小数组最多只有一个或两个元素
     * 一次对两个小数组进行判断，每次取最小的那个数放入一个新的数组，依次向后方
     * 这样新数组就时一个有序的数组，
     * 最后在按以上方式合并
     *
     * @param array 数组
     * @param start 需要排序的起点
     * @param mid   需要切割的地方，利用mid将array从逻辑上分成两个数组
     * @param end   需要排序的终点
     */
    private void merge(int[] array, int start, int mid, int end) {
        //用于存储归并后的临时数组
        int[] tempArray = new int[end - start + 1];
        //记录在临时数组中存放的下标
        int index = 0;
        //分段之后左边数据的下标
        int i = start;
        //分段之后右边数组的下标
        int j = mid + 1;
        //遍历左右两个数组，按顺序存储临时数组
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                tempArray[index] = array[i];
                i++;
            } else {
                tempArray[index] = array[j];
                j++;
            }
            index++;
        }
        //将多余的数据也存入临时数组
        while (j <= end) {
            tempArray[index] = array[j];
            j++;
            index++;
        }
        while (i <= mid) {
            tempArray[index] = array[i];
            i++;
            index++;
        }
        //将已排好序临时数组赋给原数组
        //arraycopy四个参数分别的解释：源数组，源数组下标起点，目标数组，目标数组起点，复制的数组长度
        System.arraycopy(tempArray, 0, array, start, tempArray.length);
    }

    /**
     * 取模 a%b=a-(a/b)*b  其中(a/b)的结果只取整数部分
     * 基数排序；也叫桶排序
     * 分别取初个位、十位、百位、千位……后装入不同的桶中（取初时按先进先出的原则，即队列的原则）
     *
     * 参考视频：https://www.bilibili.com/video/BV1Zt411o7Rn?p=26&vd_source=bbaa27cb7f0acba3b7a294b9aac433f2
     */
    public void radixSort(int[] array) {
        //先找出数组中的最大的数，看它有几位，决定了桶排序有几轮
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max)
                max = value;
        }
        int maxLength = String.valueOf(max).length();
        //创建用于存储数据的临时数组，即桶中；分别代表从余数从0到9
        int[][] temp = new int[10][array.length];
        //用于记录在temp中相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //n用作取百位数、千位数等时取模运算用到
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : array) {
                //计算余数，个位数取模的值都是本身
                int remainder = value / n % 10;
                //将数据存入0至9号桶中
                temp[remainder][counts[remainder]] = value;
                //记录每个桶的数组对应的数字加1
                counts[remainder]++;
            }
            //将桶中数据取出来，并将记录数量的数字置空
            int index = 0;
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] != 0) {
                    for (int k = 0; k < counts[j]; k++) {
                        array[index] = temp[j][k];
                        index++;
                    }
                    counts[j] = 0;
                }
            }
        }
    }

    /**
     * 桶排序，队列实现
     * 不用计数
     *
     * 一个三位数的整数，分别取他的个位，十位，百位的方法：
     * 例如：136
     * 个位：对10取模：136%10=6
     * 十位：先除以10在对10取模：136/10%10=3
     * 百位：先除以100在对10取模：136/100%10=1
     * 从后往前数第n位: 136/10^(n-1)%10
     */
    public void radixSortOfQueue(int[] array) {
        //先找出数组中的最大的数，看它有几位，决定了桶排序有几轮
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max)
                max = value;
        }
        int maxLength = String.valueOf(max).length();
        //创建用于存储数据的临时数组，即桶中
        ArrayQueue[] tempQueue = new ArrayQueue[10];
        Arrays.fill(tempQueue, new ArrayQueue());//给每一个队列都赋值
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : array) {
                //计算余数
                int remainder = value / n % 10;
                tempQueue[remainder].add(value);
            }
            //将桶中数据取出来，并将记录数量的数字置空
            int index = 0;
            for (ArrayQueue queue : tempQueue) {
                while (!queue.isEmpty()) {
                    array[index] = queue.poll();
                    index++;
                }
            }
        }
    }
}
