package com.techbow.homework.y2021.m09.cma;

public class LC448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            List<Integer> res = new ArrayList<>();

            for(int num: nums){
                set.add(num);
            }

            for(int i = 1; i <= nums.length; i++){
                if(!set.contains(i)){
                    res.add(i);
                }
            }
            return res;
        }
    }
}
