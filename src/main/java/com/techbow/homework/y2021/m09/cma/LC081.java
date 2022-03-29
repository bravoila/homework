package com.techbow.homework.y2021.m09.cma;

public class LC081 {
    // O(n) but easy to understand
    class Solution {
        public boolean search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int offset = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) {
                    offset = i;
                    break;
                }
            }

            while (start <= end) {
                int mid = start + (end - start) / 2;

                int midIndex = (mid + offset) % nums.length;

                if (nums[midIndex] == target) {
                    return true;
                } else if (nums[midIndex] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }

    // O(lgn) directly do binary search
    class Solution {
        public boolean search(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid = -1;
            while(start <= end) {
                mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                //If we know for sure right side is sorted or left side is unsorted
                if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                    if (target > nums[mid] && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                    //If we know for sure left side is sorted or right side is unsorted
                } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                    if (target < nums[mid] && target >= nums[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                    //any of the two sides won't change the result but can help remove duplicate from
                    //consideration, here we just use end-- but left++ works too
                } else {
                    end--;
                }
            }
            return false;
        }
    }

}
