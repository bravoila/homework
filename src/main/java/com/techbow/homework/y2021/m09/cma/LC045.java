package com.techbow.homework.y2021.m09.cma;

public class LC045 {
    class Solution {
        //     本code assume  “you can always reach the last index.”
        //     DP初始值不能是有意义答案， 用正负无穷时，可以用有效空间内的最大、小值
        //        Greedy

        public int jump(int[] nums) {
            if(nums == null || nums.length < 2) return 0;
            int result = 0;
            int preMax = 0; // 上次到的位置
            int curMax = 0; // 能到达的最远位置
            for(int i = 0; i < nums.length; i++) { // use curMax to justify whether you can hit the target or not:
                if(i > preMax) {
                    preMax = curMax;
                    result++;
                }
                curMax = Math.max(curMax, i + nums[i]); // i vs cur
                if(curMax >= nums.length - 1) return result + 1;
            }
            return 0; // 跳不到咋办
        }
    }

//    DP
    class Solution {
        public int jump(int[] nums) {
            if(nums == null || nums.length < 2) return 0;
            int len = nums.length;
            int[] dp = new int[len];
            dp[len-1] = 0;

            for(int i = len-2; i >= 0; i--){
                int minStep = Integer.MAX_VALUE;
                // 向右看，视野所及范围内最小值
                for(int j = 1; j <= nums[i]; j++){
                    if(i + j < len){
                        minStep = Math.min(dp[i+j], minStep);
                    }
                }
//                或者可以用len(nums),因为len(nums) 也是无效值，肯定跳不出去
                if (minStep == Integer.MAX_VALUE) dp[i] = Integer.MAX_VALUE;
                else dp[i] = minStep+1;
            }
            return dp[0];
        }
    }
}
