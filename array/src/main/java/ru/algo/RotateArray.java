package ru.algo;

import java.util.Arrays;

/**
 * 189. Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }

        int lt = 0;
        int rt = n - 1;
        while (lt < rt) {
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        lt = 0;
        rt = k - 1;
        while (lt < rt) {
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        lt = k;
        rt = n - 1;
        while (lt < rt) {
            swap(nums, lt, rt);
            lt++;
            rt--;
        }
    }

    private void swap(int[] nums, int lt, int rt) {
        int tmp = nums[lt];
        nums[lt] = nums[rt];
        nums[rt] = tmp;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotateArray.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{-1,-100,3,99};
        rotateArray.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
