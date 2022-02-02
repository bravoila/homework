package com.techbow.homework.y2021.m09.cma;

public class LC026 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int temp;

            for(int fast = 0; fast < nums.length; fast++){
                if(nums[slow] != nums[fast]){
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow + 1;
        }
    }
}
