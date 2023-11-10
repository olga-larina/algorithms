package ru.algo;

/**
 * 896. Monotonic Array
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 *
 * https://leetcode.com/problems/monotonic-array/description/
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean incr = true;
        boolean decr = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decr = false;
            } else if (nums[i] < nums[i - 1]) {
                incr = false;
            }
            if (!decr && !incr) {
                break;
            }
        }
        return decr || incr;
    }

    public static void main(String[] args) {
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.isMonotonic(new int[]{1,2,2,3}));
        System.out.println(monotonicArray.isMonotonic(new int[]{6,5,4,4}));
        System.out.println(monotonicArray.isMonotonic(new int[]{1,3,2}));
    }
}
