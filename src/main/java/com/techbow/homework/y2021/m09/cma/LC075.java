package com.techbow.homework.y2021.m09.cma;

public class LC075 {
    class Solution {
        public void sortColors(int[] nums) {
            Map<Integer, Integer> dict = new HashMap<>();

            for (int num : nums) {
                dict.put(num, dict.getOrDefault(num, 0) + 1);
            }

            int curr = 0;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < dict.getOrDefault(i, 0); j++){
                    nums[curr++] = i;
                }
            }
        }
    }
}
