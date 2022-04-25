package com.techbow.homework.y2021.m09.cma;

public class LC153 {
    class Solution {
        public int findMin(int[] nums) {
            // cc
            if (nums.length == 1) {
                return nums[0];
            }

            int left = 0;
            int right = nums.length - 1;
            int med;

            while(left < right){
                med = left + (right - left)/2;

                if (nums[med] > nums[med + 1]) {
                    return nums[med + 1];
                }
                if (nums[med] > nums[med + 1]) {
                    return nums[med + 1];
                }

                if(nums[med] > nums[right]){
                    left = med + 1;
                } else{
                    right = med;
                }
            }
            return nums[right];
        }
    }
}
