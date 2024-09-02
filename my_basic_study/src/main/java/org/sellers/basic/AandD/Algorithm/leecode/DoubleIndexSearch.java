package org.sellers.basic.AandD.Algorithm.leecode;

import org.sellers.basic.AandD.Algorithm.leecode.Structure.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DoubleIndexSearch {
    public static void main(String[] args) {
        DoubleIndexSearch doubleIndexSearch = new DoubleIndexSearch();
//        doubleIndexSearch.reverseWords("Let's take LeetCode contest");
        doubleIndexSearch.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 数组中有负数和重复的数
     */
    public int[] sortedSquares(int[] nums) {
        int[] sorterNums = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = nums.length;
        while (left <= right) {
            i--;
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                sorterNums[i] = nums[left] * nums[left];
                left++;
            } else {
                sorterNums[i] = nums[right] * nums[right];
                right--;
            }
        }
        return sorterNums;
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */
    public void rotateNums(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums);
        int[] frontNum = Arrays.copyOfRange(nums, 0, k);
        int[] rearNum = Arrays.copyOfRange(nums, k, nums.length);
        reverse(frontNum);
        reverse(rearNum);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = frontNum[i];
            } else {
                nums[i] = rearNum[i - k];
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pix = nums[left];
            nums[left] = nums[right];
            nums[right] = pix;
            left++;
            right--;
        }
    }

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Note that you must do this in-place without making a copy of the array.
     */
    public void moveZeroes(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[s] = nums[i];
                s++;
            }
        }
        for (int i = s; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroesSec(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * <p>
     * You must do this by modifying the input array in-place with O(1) extra memory.
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tem = s[left];
            s[left] = s[right];
            s[right] = tem;
            left++;
            right--;
        }
    }

    /**
     * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     * s="Let's take LeetCode contest"=>s'teL ekat edoCteeL tsetnoc
     */
    public void reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0, n = chars.length - 1;
        while (left < n) {
            if (right == chars.length) {
                reverseString(chars, left, right - 1);
                break;
            }
            if (chars[right] == ' ') {
                reverseString(chars, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        s = String.valueOf(chars);
        System.out.println(s);
    }

    private void reverseString(char[] chars, int begin, int end) {
        while (begin < end) {
            char tem = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tem;
            begin++;
            end--;
        }
    }

    /**
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序 排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * <p>
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * <p>
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * <p>
     * 你所设计的解决方案必须只使用常量级的额外空间。
     */
    public int[] twoSum(int[] numbers, int target) {
        //解法1；漏了一个题意，按非递减的顺序排列的数组
        /**
         * int len = numbers.length;
         *         for (int i = 0; i < len - 1; i++) {
         *             for (int j = i + 1; j < len; j++) {
         *                 if (numbers[i] + numbers[j] == target) {
         *                     numbers = new int[]{i + 1, j + 1};
         *                     return numbers;
         *                 }
         *             }
         *         }
         * return null;
         */
        //解法2：
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    /**
     * 同twoSum()，但是该数组无序
     * tips:使用hashmap降低时间复杂度
     */
    public int[] twoSumNonSorted(int[] numbers, int target) {
        Map<Integer, Integer> haspMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (haspMap.containsKey(haspMap.get(target - numbers[i]))) {
                return new int[]{haspMap.get(target - numbers[i]), i};
            }
            haspMap.put(numbers[i], i);
        }
        return null;
    }

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public ListNode middleNode(ListNode head) {
        int len = 1;
        ListNode node = head.next;
        while (node != null) {
            node = node.next;
            len++;
        }
        int index = len / 2 + 1;
        ListNode middle = null;
        int i = 1;
        while (i <= index) {
            middle = head;
            head = head.next;
            i++;
        }
        return middle;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode node = head.next;
        while (node != null) {
            node = node.next;
            len++;
        }
        int i = 0;
        ListNode tar = head;
        if (len - n == 0) {
            head = tar.next;
        } else {
            while (i <= len - n) {
                if (i == len - n - 1) {
                    tar.next = tar.next.next;
                    break;
                }
                tar = tar.next;
                i++;
            }
        }
        return head;
    }
}