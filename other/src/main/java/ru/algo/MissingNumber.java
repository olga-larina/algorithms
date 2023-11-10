package ru.algo;

/**
 * 268. Missing Number
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in
 * the range that is missing from the array.
 *
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int n = nums.length;
        return (n + 1) * n / 2 - sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber.missingNumber(new int[]{0,1}));
        System.out.println(missingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
