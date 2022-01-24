package com.techbow.homework.y2021.m09.cma;

public class LC055 {
//recursion
    class Solution {
        public boolean canJump(int[] nums){
            if(nums == null || nums.length < 2) return true;
            return canJump(nums, 0);
        }

        private boolean canJump(int[] array, int step){
            if(step >= array.length - 1) return true;
            for(int i = 1; i <= array[step]; i++){
                if(canJump(array, step + i)) return true;
            }
            return false;
        }
    }

//    DP 从右向左填
    class Solution {
        public boolean canJump(int[] nums){
            //cc
            int len = nums.length;
            boolean[] dp = new boolean[len];
            dp[len-1] = true;

            for(int i = len-2; i >= 0; i--){
                for(int j = 1; j <= nums[i]; j++){
                    if(i+j >= len-1 || dp[i+j]) { // 由远及近,依次可以跳出去。  由近及远-》if(i+j < len && dp[i+j])
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }

//Greedy
    class Solution {
        public boolean canJump(int[] nums){
            if(nums == null || nums.length == 0) return true;
            int maxRange = nums[0];
            for(int i = 0; i < nums.length; i++){
                if(maxRange < i) return false;
                maxRange = Math.max(maxRange, nums[i] + i);
                if(maxRange >= nums.length-1) return true;
            }
            return false;
        }
    }

    class Solution {
        public boolean canJump(int[] nums){
            int maxRange = nums[0];
            int n = nums.length;
            int idx = 0;

            for(int i = 0; i <=maxRange; i++){
                if(maxRange >= n - 1){
                    return true;
                }
                maxRange = Math.max(maxRange, i + nums[i]);
            }
            return false;
        }
    }


}
