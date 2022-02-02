package com.techbow.homework.y2021.m09.cma;

public class LC179 {
    class Solution {
        public String largestNumber(int[] nums) {
            if(nums.length ==0 || nums == null){
                return "";
            }

            String[] s_nums = new String[nums.length];
            for(int i = 0 ; i < nums.length ; i++){
                s_nums[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(s_nums, (a,b)->{
                String s1 = a + b ;
                String s2 = b + a ;
                return s2.compareTo(s1);
            });

            if(s_nums[0].equals("0")){
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for(String s : s_nums){
                sb.append(s);
            }
            return sb.toString();
        }
    }
}
