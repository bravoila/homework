package com.techbow.homework.y2021.m09.cma;

public class LC387 {
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            // find the index
            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
}
