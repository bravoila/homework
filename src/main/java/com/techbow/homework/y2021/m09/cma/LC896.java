package com.techbow.homework.y2021.m09.cma;

public class LC896 {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            boolean increasing = true;
            boolean decreasing = true;

            for(int i = 0 ; i < nums.length - 1; i ++){
                if(nums[i + 1] < nums[i]){
                    increasing = false;
                }

                if(nums[i + 1] > nums[i]){
                    decreasing = false;
                }
            }
            return increasing || decreasing;
        }
    }
}
