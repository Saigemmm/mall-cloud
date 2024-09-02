package org.sellers.basic.AandD.Algorithm.leecode;

import org.sellers.basic.AandD.Algorithm.leecode.Structure.ListNode;
import org.sellers.basic.AandD.Algorithm.leecode.Structure.TreeNode;

import java.util.*;

public class ComprehensiveExamination {
    public static void main(String[] args) {
        ComprehensiveExamination example = new ComprehensiveExamination();
//        System.out.println(example.bestHand(new int[]{}, new char[]{'b', 'a', 'a', 'a', 'a'}));
        System.out.println(example.checkInclusion("ab", "eidbaooo"));
    }

    /**
     * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
     * <p>
     * 下述是从好到坏你可能持有的 手牌类型 ：
     * <p>
     * "Flush"：同花，五张相同花色的扑克牌。
     * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
     * "Pair"：对子，两张大小一样的扑克牌。
     * "High Card"：高牌，五张大小互不相同的扑克牌。
     * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
     * <p>
     * 注意：返回的字符串 大小写 需与题目描述相同。
     */
    public String bestHand(int[] ranks, char[] suits) {
        int length = 5;
        char tem = suits[0];
        int standard = 0;
        for (int i = 1; i < length; i++) {
            if (tem != suits[i]) {
                standard++;
                break;
            }
            tem = suits[i];
        }
        if (standard == 0) return "Flush";
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2;
        }
        return null;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。--指的是子串里面没有重复的字符
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 解法：参考归并排序
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tempArray = new int[nums1.length + nums2.length];
        int tempIndex = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                tempArray[tempIndex] = nums1[i];
                i++;
            } else {
                tempArray[tempIndex] = nums2[j];
                j++;
            }
            tempIndex++;
        }
        while (i < nums1.length) {
            tempArray[tempIndex] = nums1[i];
            i++;
            tempIndex++;
        }
        while (j < nums2.length) {
            tempArray[tempIndex] = nums2[j];
            j++;
            tempIndex++;
        }
        int length = tempArray.length;
        if (length % 2 == 0) {
            return (double) (tempArray[length / 2 - 1] + tempArray[length / 2]) / 2;
        } else {
            return tempArray[length / 2];
        }
    }

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character key = s1.charAt(i);
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + 1);
            } else {
                map1.put(key, 1);
            }
        }
        int length2 = s2.length();
        int left = 0, right = s1.length() - 1;
        Map<Character, Integer> map2 = new HashMap<>();
        while (right < length2) {
            for (int j = left; j <= right; j++) {
                Character key = s2.charAt(j);
                if (map2.containsKey(key)) {
                    map2.put(key, map2.get(key) + 1);
                } else {
                    map2.put(key, 1);
                }
            }
            if (map1.equals(map2))
                return true;
            map2.clear();
            left++;
            right++;
        }
        return false;
    }

    /**
     * 二维数组：
     * int [ ][ ]  arr=new  int [5][3];  “5行3例”
     * int [][] arr=new int[][]{{4,5,6,8},{2,3},{1,6,9}}; = new int[3][4]  列数看第一个数组的长度，行数看有几个数组
     * <p>
     * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
     * <p>
     * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
     * <p>
     * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
     * 重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
     * <p>
     * 最后返回 经过上色渲染后的图像 。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, color, originalColor);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int newColor, int originColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return;
        if (image[x][y] == originColor) {
            image[x][y] = newColor;
            dfs(image, x - 1, y, newColor, originColor);
            dfs(image, x + 1, y, newColor, originColor);
            dfs(image, x, y - 1, newColor, originColor);
            dfs(image, x, y + 1, newColor, originColor);
        }
    }

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     * <p>
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * <p>
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     * <p>
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     * <p>
     * https://leetcode.cn/problems/max-area-of-island/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=j47j51v
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    count = Math.max(count, dfsIsland(grid, i, j));
                }
            }
        }
        return count;
    }

    private int dfsIsland(int[][] grid, int x, int y) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] != 1)
            return 0;
        // 访问过的设置为0，下次不再访问
        grid[x][y] = 0;
        int sum = 1;
        sum = sum + dfsIsland(grid, x - 1, y);
        sum = sum + dfsIsland(grid, x + 1, y);
        sum = sum + dfsIsland(grid, x, y - 1);
        sum = sum + dfsIsland(grid, x, y + 1);
        return sum;
    }

    /**
     * 给你两棵二叉树： root1 和 root2 。
     * <p>
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
     * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：
     * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
     * 否则，不为 null 的节点将直接作为新二叉树的节点。
     * <p>
     * 返回合并后的二叉树。
     * <p>
     * 注意: 合并过程必须从两个树的根节点开始。
     * <p>
     * https://leetcode.cn/problems/merge-two-binary-trees/solutions/82841/dong-hua-yan-shi-di-gui-die-dai-617he-bing-er-cha-/?orderBy=most_votes
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 != null ? root1 : root2;
        }
        return iterate(root1, root2);
    }

    private TreeNode iterate(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 != null ? t1 : t2;
        t1.val = t1.val + t2.val;
        t1.left = iterate(t1.left, t2.left);
        t1.right = iterate(t1.right, t2.right);
        return t1;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
