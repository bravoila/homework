package com.techbow.homework.y2021.m09.cma;

public class LC532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            int n = nums.length;
            int slow = 0;
            int fast = 1;
            int res = 0;

            Arrays.sort(nums);

            while (slow < n && fast < n) {
                if (slow == fast || nums[fast] - nums[slow] < k) {
                    fast++;
                } else if (nums[fast] - nums[slow] > k) {
                    slow++;
                } else {
                    slow++;
                    res++;
//                 skip the same char
                    while (slow < n && nums[slow] == nums[slow - 1])
                        slow++;
                }
            }
            return res;
        }
    }
}
