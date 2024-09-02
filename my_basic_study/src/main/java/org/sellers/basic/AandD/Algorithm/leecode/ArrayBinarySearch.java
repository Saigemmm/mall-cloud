package org.sellers.basic.AandD.Algorithm.leecode;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        ArrayBinarySearch arrayBinarySearch = new ArrayBinarySearch();
        System.out.println(arrayBinarySearch.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    /**
     * @param array  目标数组，要求数组为有序数组
     * @param target 所要查询的目标
     * @return 目标所在下标
     */
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else {
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] < target) {
            return left + 1;
        } else {
            return left;
        }
    }
}
