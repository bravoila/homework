package com.techbow.homework.y2021.m09.cma;

public class LC1291 {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            String numbers = "123456789";
            List<Integer> res = new ArrayList<>();

            int lowLen = String.valueOf(low).length();
            int highLen = String.valueOf(high).length();

            for(int i = lowLen ; i <= highLen; i ++){
                for(int j = 0; j < 10 - i; j ++){
                    int num = Integer.parseInt(numbers.substring(j, j + i));
                    if(num >= low && num <= high){
                        res.add(num);
                    }
                }
            }
            return res;
        }
    }
}
