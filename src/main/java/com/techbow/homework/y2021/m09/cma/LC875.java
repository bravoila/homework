package com.techbow.homework.y2021.m09.cma;

public class LC875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 1;

            for (int pile : piles) {
                right = Math.max(right, pile);
            }

            while(left <= right){
                int med = left + (right - left)/2;
                int hours = 0;

                for(int pile: piles){
                    hours += Math.ceil((double) pile/med);
                }

                if(hours <= h){
                    right = med - 1;
                }else{
                    left = med + 1;
                }
            }
            return left;
        }
    }


}
