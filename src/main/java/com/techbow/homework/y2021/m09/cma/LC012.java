package com.techbow.homework.y2021.m09.cma;

public class LC012 {
    class Solution {
        public String intToRoman(int num) {
            String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (num > 0) {
                while(num >= numbers[i]) {
                    sb.append(strs[i]);
                    num -= numbers[i];
                }
                i++;
            }
            return sb.toString();
        }

    }
}
