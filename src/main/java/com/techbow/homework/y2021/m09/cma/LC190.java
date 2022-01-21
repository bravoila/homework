package com.techbow.homework.y2021.m09.cma;

public class LC190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                int temp = (n >> i) & 1;
                res |= temp << (31 - i);
            }
            return res;
        }
    }
// XOR
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            for (int i = 0; i < 16; i++) {
                int left = 1 & (n >> (31 - i));
                int right = 1 & (n >> i);
                if (left != right) { // XOR
                    n ^= 1 << (31 - i);
                    n ^= 1 << i;
                }
            }
            return n;
        }
    }
}
