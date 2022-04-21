package com.techbow.homework.y2021.m09.cma;

public class LC162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0;
            int n = nums.length;
            int right = n;
            int med;

            while(left <= right){
                med = left + (right - left)/2;
                if((med == 0 || nums[med] > nums[med -1]) &&(med == n - 1 || nums[med] > nums[med + 1])){
                    return med;
                } else if(med == 0 || nums[med - 1] < nums[med]){
                    left = med + 1;
                } else{
                    right = med - 1;
                }
            }
            throw null;
        }
    }
}
