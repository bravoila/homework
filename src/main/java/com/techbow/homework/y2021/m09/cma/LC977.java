package com.techbow.homework.y2021.m09.cma;

public class LC977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int left = 0;
            int n = nums.length;
            int right = n - 1;
            int[] res = new int[n];

            for(int i = n - 1; i >=0; i--){
                int square;
                if(Math.abs(nums[left]) < Math.abs(nums[right])){
                    square = nums[right];
                    right--;
                } else{
                    square = nums[left];
                    left ++;
                }
                res[i] = square * square;
            }
            return res;
        }
    }
}
