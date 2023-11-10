package ru.algo;

/**
 * 1732. Find the Highest Altitude
 *
 * The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between
 * points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 *
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int g : gain) {
            cur += g;
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        FindHighestAltitude findHighestAltitude = new FindHighestAltitude();
        System.out.println(findHighestAltitude.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(findHighestAltitude.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
