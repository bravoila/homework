package com.techbow.homework.y2021.m09.cma;

public class LC028 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) return -1;

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
            return -1;
        }
    }


}
