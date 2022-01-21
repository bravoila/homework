package com.techbow.homework.y2021.m09.cma;

public class LC344 {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            char temp;

            while(right > left){
                temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left ++;
                right --;

            }
        }
    }
}
