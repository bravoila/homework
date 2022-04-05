package com.techbow.homework.y2021.m09.cma;

public class LC011 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxwat = 0;

            while(left < right){
                maxwat = Math.max(maxwat, (right - left) * Math.min(height[left], height[right]));
                if(height[left] < height[right]){
                    left++;
                } else{
                    right--;
                }
            }
            return maxwat;
        }
    }
}
