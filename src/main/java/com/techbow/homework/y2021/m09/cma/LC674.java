package com.techbow.homework.y2021.m09.cma;

public class LC674 {
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


}
