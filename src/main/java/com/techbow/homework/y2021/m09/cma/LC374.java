package com.techbow.homework.y2021.m09.cma;

public class LC374 {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 0;
            int high = n;
            int med = -1;
            int res = 0;
            while(low <= high){
                med = low + (high - low)/2;
                res = guess(med);
                if(res == 0){
                    return med;
                } else if(res < 0){
                    high = med - 1;
                } else{
                    low = med + 1;
                }
            }
            return -1;
        }
    }
}
