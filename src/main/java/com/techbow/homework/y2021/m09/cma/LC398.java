package com.techbow.homework.y2021.m09.cma;

public class LC398 {
    class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            if(nums == null) return;
            this.nums = Arrays.copyOf(nums, nums.length);
        }

        public int pick(int target) {
            int len = nums.length;
            int ret = -1;
            int count = 0;
            for(int i = 0; i < len; i++){
                if(target == nums[i]){
                    count ++;
                    int rand = new Random().nextInt(count);
                    if(rand == 0){
                        ret = i;
                    }
                }
            }
            return ret;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
