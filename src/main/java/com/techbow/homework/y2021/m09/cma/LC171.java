package com.techbow.homework.y2021.m09.cma;

public class LC171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            char[] ca = columnTitle.toCharArray();
            int res = 0;
            for(char s: ca){
                res = res * 26;
                res += s - 'A' + 1;
            }
            return res;
        }
    }
}
