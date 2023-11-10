package ru.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Number of Submatrices That Sum to Target
 *
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/
 */
public class SubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rs = matrix.length;
        int cs = matrix[0].length;

        // префиксные суммы для каждой строки
        for (int r = 0; r < rs; r++) {
            for (int c = 1; c < cs; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }

        // проходимся по всем комбинациям столбцов, считаем аналогично https://leetcode.com/problems/subarray-sum-equals-k/description/
        int res = 0;

        for (int c1 = 0; c1 < cs; c1++) {
            for (int c2 = c1; c2 < cs; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int cur = 0;
                for (int r = 0; r < rs; r++) {
                    cur += matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SubmatricesThatSumToTarget submatricesThatSumToTarget = new SubmatricesThatSumToTarget();
        System.out.println(submatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{
            new int[]{0,1,0},
            new int[]{1,1,1},
            new int[]{0,1,0}
        }, 0));
        System.out.println(submatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{
            new int[]{1,-1},
            new int[]{-1,1}
        }, 0));
        System.out.println(submatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{
            new int[]{904}
        }, 0));
    }
}
