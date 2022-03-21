package com.techbow.homework.y2021.m09.cma;

public class LC260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int[] res = new int[2];
            int xor = 0;
            for(int n:nums){ // get x ^ y
                xor ^= n;
            }
            int mask = 1;
            while((mask & xor) == 0){
                mask <<= 1;//mask 里存的就是第一个为1的那一位的位置
            }

            int group1 = 0;
            int group2 = 0;
            for(int n : nums){
                if((n & mask) == 0){ // n在标示位bit是0
                    group1 ^= n;

                }
            }

            res[0] = group1;
            res[1] = xor^group1;
            return res;
        }
    }
}
