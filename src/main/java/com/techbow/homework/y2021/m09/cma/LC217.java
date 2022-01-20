package com.techbow.homework.y2021.m09.cma;

public class LC217 {


    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> numSet = new HashSet<>();

            for(int num:nums){
                if( numSet.contains(num)){
                    return true;
                }else{
                    numSet.add(num);
                }
            }
            return false;
        }
    }

}
