package com.techbow.homework.y2021.m09.cma;

public class LC231 {
//    Recursion

    class Solution {
        public boolean isPowerOfTwo(int n) {
            // Corner Case
            if (n <= 0) {
                return false;
            }
            // Base Case
            if (n == 1) {
                return true;
            }
            //
            if (n % 2 != 0) {
                return false;
            }
            return isPowerOfTwo(n / 2);
        }
    }

//    While Loop

    class Solution {
        public boolean isPowerOfTwo(int n) {
            //int rem = 0;
            while (n > 1) {
                if (n % 2 != 0) return false;
                n /= 2;
            }
            return n == 1;
        }
    }

    class Solution {
        public boolean isPowerOfTwo(int n) {
            long mask = 1;  // long, int 会 overflow
            while(mask < n){
                mask *= 2;    // mask <<= 1
            }
            return mask == n;
        }
    }

//    Bit1
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0){
                return false;
            }

            int res = 0;

            while(n != 0){
                if( (n & 1) != 0){
                    res ++;
                }
                n >>>= 1;
            }
            return res == 1;
        }
    }

//    Bit2
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return (n > 0) && ((n & (n - 1)) == 0);
        }
    }
}
