package ru.algo;

import java.util.Arrays;

/**
 * 1314. Matrix Block Sum
 *
 * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 *   i - k <= r <= i + k,
 *   j - k <= c <= j + k, and
 *   (r, c) is a valid position in the matrix.
 *
 * https://leetcode.com/problems/matrix-block-sum/description/
 */
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pr = new int[m + 1][];
        pr[0] = new int[n + 1];
        for (int r = 0; r < m; r++) {
            pr[r + 1] = new int[n + 1];
            for (int c = 0; c < n; c++) {
                int otherSum = pr[r][c + 1] + pr[r + 1][c] - pr[r][c];
                pr[r + 1][c + 1] = otherSum + mat[r][c];
            }
        }

        int[][] answer = new int[m][];
        for (int r = 0; r < m; r++) {
            answer[r] = new int[n];
            for (int c = 0; c < n; c++) {
                answer[r][c] = pr[Math.min(m, r + k + 1)][Math.min(n, c + k + 1)]
                    - (r < k ? 0 : pr[r - k][Math.min(n, c + k + 1)])
                    - (c < k ? 0 : pr[Math.min(m, r + k + 1)][c - k])
                    + (r < k || c < k ? 0 : pr[r - k] [c - k]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        System.out.println(Arrays.deepToString(matrixBlockSum.matrixBlockSum(new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9}
        }, 1)));
        System.out.println(Arrays.deepToString(matrixBlockSum.matrixBlockSum(new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9}
        }, 2)));
    }
}
