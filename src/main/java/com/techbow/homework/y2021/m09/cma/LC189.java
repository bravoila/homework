package com.techbow.homework.y2021.m09.cma;

public class LC189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k%n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int left, int right ){
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
