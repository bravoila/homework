package com.techbow.homework.y2021.m09.cma;

public class LC238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // cc
            int n = nums.length;
            // preprocessing
            int[] left = new int[n]; // i（不含）以左的所有数的乘积
            left[0] = 1;

            for(int i = 1; i < n; i++){
                left[i] = left[i - 1] * nums[i - 1];
            }

            int[] right = new int[n]; // i（不含）以右的所有数的乘积
            right[n - 1] = 1;
            for(int i = n - 2; i > - 1; i--){
                right[i] = right[i + 1] * nums[i + 1];
            }

            int[] res = new int[n];
            for(int i = 0; i < n; i++){
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }
}
