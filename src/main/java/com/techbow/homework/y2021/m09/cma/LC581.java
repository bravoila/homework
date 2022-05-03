package com.techbow.homework.y2021.m09.cma;

public class LC581 {
    // brute force
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] snums = nums.clone();
            Arrays.sort(snums);
            int start = snums.length, end = 0;
            for (int i = 0; i < snums.length; i++) {
                if (snums[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end - start >= 0 ? end - start + 1 : 0);
        }
    }
    // two pointer
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            int start = 0;
            int end = -1;

            while(right >=0){
                if(nums[left] >= max){
                    max = nums[left];
                }
                else{
                    end = left;
                }

                if(nums[right] <= min){
                    min = nums[right];
                } else{
                    start = right;
                }

                left++;
                right--;
            }
            return end - start + 1;
        }
    }
}
