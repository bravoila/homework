package com.techbow.homework.y2021.m09.cma;

public class LC744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;
            int med;

            while(left <= right){
                med = left + (right - left)/2;
                if(letters[med] > target){
                    right = med - 1;
                } else{
                    left = med + 1;
                }
            }
            return letters[left % letters.length];
        }
    }
}
