package com.techbow.homework.y2021.m09.cma;

public class LC1342 {
    class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while(num != 0){
                if(num % 2 == 0){
                    num /= 2;
                } else{
                    num -= 1;
                }
                count++;
            }
            return count;
        }
    }
    // bit
    class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while(num > 0){
                if((num & 1) == 0){
                    num = num >> 1;
                } else{
                    num = num ^ 1;
                }
                count++;
            }
            return count;
        }
    }
    // bit2
    class Solution {
        public int numberOfSteps(int num) {
            if(num == 0){
                return 0;
            }
            int count = 0;

            while(num > 0){
                if( (num & 1) != 0){
                    count++;
                }
                num >>= 1;
                count++;
            }
            return count - 1;
        }
    }
}
