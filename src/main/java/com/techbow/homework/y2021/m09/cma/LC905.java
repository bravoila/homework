package com.techbow.homework.y2021.m09.cma;

public class LC905 {
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            if(nums == null || nums.length <= 1){
                return nums;
            }

            int slow = 0;
            int tmp;

            for(int fast = 0; fast < nums.length; fast++){
                if(nums[fast] % 2 == 0){
                    tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                    slow++;
                }
            }
            return nums;
        }
    }
}
