package com.techbow.homework.y2021.m09.cma;

public class LC2104 {
    class Solution {
        public long subArrayRanges(int[] nums) {
            long res = 0;
            for(int i = 0; i < nums.length; i++){
                int max = nums[i];
                int min = nums[i];
                for(int j = i; j < nums.length; j++){
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    res += max - min;
                }
            }
            return res;
        }
    }
}
