package org.sellers.basic.AandD.Algorithm.other;

/**
 * 水仙花数是指一个 n 位数 ( n≥3 )，它的每个位上的数字的 n 次幂之和等于它本身。（例如：
 * 1^3 + 5^3+ 3^3 = 153）；给你A和B，求[A,B]区间内有多少个水仙花数
 */
public class NarcissusFigure {
    public int countSYHNumbers(int A, int B) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (ifSYHFigure(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean ifSYHFigure(int figure) {
        int original = figure;
        int length = String.valueOf(figure).length();
        int sum = 0;
        int remain;
        while (figure > 0) {
            remain = figure % 10;
            sum = (int) (sum + Math.pow(remain, length));
            figure = figure / 10;
        }
        return sum == figure;
    }
}
