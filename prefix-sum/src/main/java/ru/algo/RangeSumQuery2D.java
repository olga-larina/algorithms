package ru.algo;

/**
 * 304. Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
 * and lower right corner (row2, col2).
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2D {
    private final int[][] pr;

    public RangeSumQuery2D(int[][] matrix) {
        pr = new int[matrix.length + 1][];
        pr[0] = new int[matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            pr[r + 1] = new int[matrix[r].length + 1];
            for (int c = 0; c < matrix[r].length; c++) {
                int otherSum = pr[r][c + 1] + pr[r + 1][c] - pr[r][c];
                pr[r + 1][c + 1] = otherSum + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        col2++;
        return pr[row2][col2] - pr[row2][col1] - pr[row1][col2] + pr[row1][col1];
    }

    public static void main(String[] args) {
        RangeSumQuery2D rangeSumQuery2D = new RangeSumQuery2D(new int[][]{
            new int[]{3, 0, 1, 4, 2},
            new int[]{5, 6, 3, 2, 1},
            new int[]{1, 2, 0, 1, 5},
            new int[]{4, 1, 0, 1, 7},
            new int[]{1, 0, 3, 0, 5}
        });
        System.out.println(rangeSumQuery2D.sumRegion(2,1, 4, 3));
        System.out.println(rangeSumQuery2D.sumRegion(1,1, 2, 2));
        System.out.println(rangeSumQuery2D.sumRegion(1,2, 2, 4));
    }
}
