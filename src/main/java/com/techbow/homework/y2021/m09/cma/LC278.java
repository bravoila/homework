package com.techbow.homework.y2021.m09.cma;

public class LC278 {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n - 1;

            while(left <= right){
                int med = left + (right - left)/2;
                if(isBadVersion(med)){
                    right = med - 1;
                } else{
                    left = med + 1;
                }
            }
            return left;
        }
    }
}
