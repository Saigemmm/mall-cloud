package org.sellers.basic.AandD.Algorithm.leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 一个随机长度的数组，元素是任意0到9
 * 任意选择数组的元素拼成一个树，求最大的能被三整除的数，用str表示
 */
public class MaxArrayDivideThree {
    public String execute(int[] array) {
        //将数组转为降序排序
        List<Integer> arrayList = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int sum = arrayList.stream().reduce(Integer::sum).orElse(0);
        if (sum % 3 == 0) {
            StringBuilder sb = new StringBuilder();
            arrayList.forEach(sb::append);
            return sb.toString();
        } else if (sum % 3 == 1) {
            StringBuilder sb = new StringBuilder();
            int pix = 0;
            int index = 0;
            for (int i = arrayList.size() - 1; i > 0; i--) {
                if (arrayList.get(i) % 3 == 1) {
                    pix++;
                    index = i;
                    break;
                }
            }
            if (pix > 0) {
                arrayList.remove(index);
                arrayList.forEach(sb::append);
            } else {
                int pixTwo = 0;
                int indexTwo1 = 0;
                int indexTwo2 = 0;
                for (int i = arrayList.size() - 1; i > 0; i--) {
                    if (arrayList.get(i) % 3 == 2) {
                        pixTwo++;
                        if (pixTwo == 1) {
                            indexTwo1 = i;
                        } else {
                            indexTwo2 = i;
                            break;
                        }
                    }
                }
                if (pixTwo == 2) {
                    arrayList.remove(indexTwo1);
                    arrayList.remove(indexTwo2);
                    arrayList.forEach(sb::append);
                }
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            int pix = 0;
            int index = 0;
            for (int i = arrayList.size() - 1; i > 0; i--) {
                if (arrayList.get(i) % 3 == 2) {
                    pix++;
                    index = i;
                    break;
                }
            }
            if (pix > 0) {
                arrayList.remove(index);
                arrayList.forEach(sb::append);
            } else {
                int pixTwo = 0;
                int indexTwo1 = 0;
                int indexTwo2 = 0;
                for (int i = arrayList.size() - 1; i > 0; i--) {
                    if (arrayList.get(i) % 3 == 1) {
                        pixTwo++;
                        if (pixTwo == 1) {
                            indexTwo1 = i;
                        } else {
                            indexTwo2 = i;
                            break;
                        }
                    }
                }
                if (pixTwo == 2) {
                    arrayList.remove(indexTwo1);
                    arrayList.remove(indexTwo2);
                    arrayList.forEach(sb::append);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MaxArrayDivideThree maxArrayDivideThree = new MaxArrayDivideThree();
        String s = maxArrayDivideThree.execute(new int[]{1, 2, 3, 0, 0, 7, 6, 9, 4, 1, 2});
        System.out.println(s);
        System.out.println(Long.parseLong(s) % 3);
    }
}
