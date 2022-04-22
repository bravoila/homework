package com.techbow.homework.y2021.m09.cma;

public class LC033 {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int med;
            while(left <= right){
                med = left + (right - left)/2;
                if(nums[med] == target){
                    return med;
                } else if(nums[med] >= nums[left]){ // 前段升序
                    if(nums[left] <= target && nums[med] > target){
                        right = med - 1;
                    } else{
                        left = med + 1;
                    }
                } else{
                    if(nums[right] >= target && nums[med] < target){
                        left = med + 1;
                    } else{
                        right = med - 1;
                    }
                }
            }
            return -1;
        }
    }
}
