package com.techbow.homework.y2021.m09.cma;

public class LC154 {
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

                if(nums[med] < nums[right]){
                    right = med;
                } else if(nums[med] > nums[right]){
                    left = med + 1;
                } else{
                    right --;
                }
            }
            return nums[left];
        }
    }
}
