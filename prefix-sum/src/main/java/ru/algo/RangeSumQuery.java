package ru.algo;

/**
 * 303. Range Sum Query - Immutable
 *
 * Given an integer array nums, handle multiple queries of the following type:
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQuery {
    private final int[] sums;

    public RangeSumQuery(int[] nums) {
        this.sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i];
            if (i > 0) {
                sums[i] += sums[i - 1];
            }
        }
    }

    public int sumRange(int left, int right) {
        return sums[right] - ((left > 0) ? sums[left - 1] : 0);
    }

    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery = new RangeSumQuery(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQuery.sumRange(0,2));
        System.out.println(rangeSumQuery.sumRange(2,5));
        System.out.println(rangeSumQuery.sumRange(0,5));
    }
}
