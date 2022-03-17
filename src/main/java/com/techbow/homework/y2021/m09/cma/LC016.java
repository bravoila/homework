package com.techbow.homework.y2021.m09.cma;

public class LC016 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int diff = Integer.MAX_VALUE;
            int n = nums.length;
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                int left = i + 1;
                int right = n - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(Math.abs(target - sum) < Math.abs(diff)){
                        diff = target - sum;
                    }
                    if(sum < target){
                        left++;
                    } else if(sum > target){
                        right--;
                    } else{
                        break;
                    }
                }
            }
            //不要直接return sum，因为sum不一定是跟target差最小的，diff才是根据条件不断更新或保留的
            return target - diff;
        }
    }
}
