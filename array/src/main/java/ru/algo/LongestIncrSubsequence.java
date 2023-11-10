package ru.algo;

/**
 * 674. Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence
 * (i.e. subarray). The subsequence must be strictly increasing.
 *
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class LongestIncrSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncrSubsequence longestIncrSubsequence = new LongestIncrSubsequence();
        System.out.println(longestIncrSubsequence.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(longestIncrSubsequence.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }
}
