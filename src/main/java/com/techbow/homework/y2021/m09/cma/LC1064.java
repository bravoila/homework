package com.techbow.homework.y2021.m09.cma;

public class LC1064 {
    class Solution {
        public int fixedPoint(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            int med = 0;
            int res = -1;

            while(left <= right){
                med = (left + right) /2;
                if(arr[med] == med){
                    res = med;
                    right = med - 1;
                } else if (arr[med] < med){
                    left = med + 1;
                } else{
                    right = med - 1;
                }
            }
            return res;
        }
    }
}
