package com.techbow.homework.y2021.m09.cma;

public class LC053 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int dp = nums[0];
            int max = dp;

            for(int i = 1; i < len ; i ++){
                if(dp > 0){
                    dp += nums[i];
                } else{
                    dp = nums[i];
                }
                max = Math.max(dp, max);
            }

            return max;
        }
    }
}
