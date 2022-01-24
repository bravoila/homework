package com.techbow.homework.y2021.m09.cma;

public class LC674 {
//    slow fast指针
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums.length == 0 || nums == null) return 0;

            int slow = 0;
            int fast = 1;
            int maxValue = nums[0];
            int res = 1;
            while(fast < nums.length){
                if(nums[fast] <= nums[fast-1]){
                    res = Math.max(res, fast - slow);
                    slow = fast;
                    maxValue = nums[fast];
                }

                fast ++;
            }
            res = Math.max(res, fast - slow);
            return res;
        }
    }

//    DP

    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
//         dp is the max length, use reuse and reset method.
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = dp[0];

            for(int i = 1; i < nums.length; i ++){
                if(nums[i] > nums[i - 1]){
                    dp[i] = dp[i - 1] + 1;
                } else{
                    dp[i] = 1;
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
// reuse
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
//         dp is the max length, use reuse and reset method.
            int cur = 1;
            int max = cur;

            for(int i = 1; i < nums.length; i ++){
                if(nums[i] > nums[i - 1]){
                    cur++ ;
                } else{
                    cur = 1;
                }
                max = Math.max(max, cur);
            }
            return max;
        }
    }
}
