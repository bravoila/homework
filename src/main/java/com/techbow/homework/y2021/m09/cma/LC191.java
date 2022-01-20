package com.techbow.homework.y2021.m09.cma;

public class LC191 {
    //    Solution 1
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            int mask = 1;

            for(int i = 0; i < 32; i++){
                if( (n & mask) != 0 ){
                    res++;
                }
                n>>=1;
            }
            return res;
        }
    }


    //    Solution 2
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            int mask = 1;

            for(int i = 0; i < 32; i++){
                if( (n & mask) != 0 ){
                    res++;
                }
                mask<<=1;
            }
            return res;
        }
    }


//    Solution 3
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;

            while(n != 0){
                if( (n & 1) != 0){
                    res ++;
                }
                n >>>= 1;
            }
            return res;
        }
    }
}
