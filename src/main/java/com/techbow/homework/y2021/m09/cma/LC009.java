package com.techbow.homework.y2021.m09.cma;

public class LC009 {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }
            int newNum = 0;
            int original = x;
            while(original != 0){
                newNum = newNum *10 + original%10;
                original = original/10;
            }

            return newNum == x;
        }
    }
}
