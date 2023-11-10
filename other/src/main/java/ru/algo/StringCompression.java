package ru.algo;

/**
 * 443. String Compression
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *     If the group's length is 1, append the character to s.
 *     Otherwise, append the character followed by the group's length.
 *
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {
    public int compress(char[] chars) {
        char c = chars[0];
        int i = 0;
        int cnt = 1;
        for (int j = 1; j < chars.length; j++) {
            if (chars[j] == c) {
                cnt++;
            } else {
                i = write(chars, i, cnt, c);
                c = chars[j];
                cnt = 1;
            }
        }
        return write(chars, i, cnt, c);
    }

    private int write(char[] chars, int i, int cnt, char c) {
        chars[i++] = c;
        if (cnt > 1) {
            String cntStr = Integer.toString(cnt);
            for (char cc : cntStr.toCharArray()) {
                chars[i++] = cc;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(stringCompression.compress(new char[]{'a'}));
        System.out.println(stringCompression.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
