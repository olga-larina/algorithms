package ru.algo;

/**
 * 724. Find Pivot Index
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
 * of all the numbers strictly to the index's right.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftsum = 0;
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i]) {
                pivot = i;
                break;
            }
            leftsum += nums[i];
        }
        return pivot;
    }

    private int pivotIndex0(int[] nums) {
        int[] prefixes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixes[i + 1] = prefixes[i] + nums[i];
        }

        int sum = prefixes[nums.length];
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prefixes[i] == sum - prefixes[i] - nums[i]) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(findPivotIndex.pivotIndex0(new int[]{1,7,3,6,5,6}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{1,2,3}));
        System.out.println(findPivotIndex.pivotIndex0(new int[]{1,2,3}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{2,1,-1}));
        System.out.println(findPivotIndex.pivotIndex0(new int[]{2,1,-1}));
    }
}
