package ru.algo;

/**
 * 287. Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {

    // Алгоритм черепахи и зайца
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicate1(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] = -nums[cur];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }

    // можно ещё решить через сортировку и HashSet
    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate1(new int[]{1,3,4,2,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate1(new int[]{3,1,3,4,2}));
    }
}
