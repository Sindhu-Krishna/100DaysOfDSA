/*
Given two strings s and t, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"  
Output: "BANC"

Example 2:
Input: s = "a", t = "a"  
Output: "a"

Example 3:
Input: s = "a", t = "aa"  
Output: ""

 */

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, needCount = need.size();
        int left = 0, minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue())
                have++;

            while (have == needCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar))
                    have--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(solver.minWindow(s, t)); // Output: BANC
    }
}
