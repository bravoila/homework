package com.techbow.homework.y2021.m09.cma;

public class LC201 {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int count = 0;
            while(left != right){
                count++;
                left >>= 1;
                right >>= 1;
            }
            return left<<count;
        }
    }
}
