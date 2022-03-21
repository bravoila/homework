package com.techbow.homework.y2021.m09.cma;

public class LC169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int[] bitCount = new int[32];
            for(int n : nums){
                for(int i = 0 ; i < 32; i++){
                    int val = n & 1;
                    bitCount[i] += val;
                    n = n >> 1;
                }
            }
            int res = 0;
            for(int i = 0 ; i < 32; i ++){
                if(bitCount[i] > nums.length/2){
                    res +=  1 << i;
                }
            }
            return res;
        }
    }
}
