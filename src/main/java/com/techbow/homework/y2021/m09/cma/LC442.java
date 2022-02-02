package com.techbow.homework.y2021.m09.cma;

public class LC442 {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            Map<Integer, Integer> dict = new HashMap<>();
            List<Integer> res = new ArrayList<>();

            for(int i: nums){
                if(dict.containsKey(i)){
                    res.add(i);
                }else{
                    dict.put(i, 1);
                }
            }
            return res;
        }
    }
}
