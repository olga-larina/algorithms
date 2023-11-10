package ru.algo;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i]. You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int val = 1;
        int[] answer = new int[nums.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = val;
            val *= nums[i];
        }

        val = 1;
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] *= val;
            val *= nums[i];
        }

        return answer;
    }

    public int[] productExceptSelf1(int[] nums) {

        int[] arr1 = new int[nums.length];
        arr1[0] = 1;
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = arr1[i - 1] * nums[i - 1];
        }

        int[] arr2 = new int[nums.length];
        arr2[arr2.length - 1] = 1;
        for (int i = arr2.length - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] * nums[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr1[i] * arr2[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf1(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[] {-1,1,0,-3,3})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf1(new int[] {-1,1,0,-3,3})));
    }
}
