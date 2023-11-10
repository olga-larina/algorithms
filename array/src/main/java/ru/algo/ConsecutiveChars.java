package ru.algo;

/**
 * 1446. Consecutive Characters
 *
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * Given a string s, return the power of s.
 *
 * https://leetcode.com/problems/consecutive-characters/
 */
public class ConsecutiveChars {
    public int maxPower(String s) {
        int power = 0;
        char c = '0';
        int cnt = 0;
        for (char cc : s.toCharArray()) {
            if (cc == c) {
                cnt++;
            } else {
                cnt = 1;
                c = cc;
            }
            power = Math.max(power, cnt);
        }
        return power;
    }

    public static void main(String[] args) {
        ConsecutiveChars consecutiveChars = new ConsecutiveChars();
        System.out.println(consecutiveChars.maxPower("leetcode"));
        System.out.println(consecutiveChars.maxPower("abbcccddddeeeeedcba"));
    }
}
