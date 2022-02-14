package com.techbow.homework.y2021.m09.cma;

public class LC408 {
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0, j = 0;

            while (j < abbr.length()) {
                char ch = abbr.charAt(j);
                if (Character.isDigit(ch)) {
                    if (ch == '0') return false;
                    int num = 0;
                    while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                        num = num * 10 + abbr.charAt(j) - '0';
                        j++;
                    }

                    i += num;
                    if (i > word.length()) return false;
                } else {
                    if (i >= word.length() || word.charAt(i) != ch) return false;
                    i++;
                    j++;
                }
            }
            return i == word.length();
        }
    }
}
