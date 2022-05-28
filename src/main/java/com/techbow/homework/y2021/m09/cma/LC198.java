package com.techbow.homework.y2021.m09.cma;

public class LC198 {
    // DP1
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if(n == 0){
                return 0;
            }

            int[] res = new int[n + 1];
            res[n] = 0;
            res[n - 1] = nums[n - 1];

            for(int i = n -2; i>-1; i--){
                res[i] = Math.max(res[i + 1], res[i + 2] + nums[i]);
            }
            return res[0];
        }
    }

    // dp2
    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int n = nums.length;

            if(n == 1){
                return nums[0];
            }

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for(int i = 2; i < n; i++){
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i - 1]);
            }
            return dp[n-1];
        }
    }
}
