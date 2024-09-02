package org.sellers.basic.AandD.Algorithm.sort;

import java.util.Arrays;

public class SortAlgorithmTest {
    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm=new SortAlgorithm();
        int[] array=new int[]{5,1,0,3,2,8,6,4,7,9,99,123,55};
        sortAlgorithm.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
