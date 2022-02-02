package com.techbow.homework.y2021.m09.cma;

public class LC080 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 1;
            int count = 1;
            int fast;
            for(fast = 1; fast < nums.length; fast++){
                if(nums[fast] == nums[fast - 1]) {
                    count++;
                } else{
                    count = 1;
                }
                if(count <= 2){
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            return slow;
        }
    }
// best solution
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int n : nums)
                if (i < 2 || n > nums[i-2])
                    nums[i++] = n;
            return i;
        }
    }

}
