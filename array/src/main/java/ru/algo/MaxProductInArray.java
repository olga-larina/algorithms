package ru.algo;

/**
 * 1464. Maximum Product of Two Elements in an Array
 *
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
 */
public class MaxProductInArray {
    public int maxProduct(int[] nums) {
        int m1 = 0;
        int i = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > m1) {
                i = k;
                m1 = nums[k];
            }
        }

        int m2 = 0;
        int j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > m2 && i != k) {
                j = k;
                m2 = nums[k];
            }
        }

        return (m1 - 1) * (m2 - 1);
    }

    public static void main(String[] args) {
        MaxProductInArray maxProductInArray = new MaxProductInArray();
        System.out.println(maxProductInArray.maxProduct(new int[]{3,4,5,2}));
        System.out.println(maxProductInArray.maxProduct(new int[]{1,5,4,5}));
        System.out.println(maxProductInArray.maxProduct(new int[]{3,7}));
    }
}
