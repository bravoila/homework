package com.techbow.homework.y2021.m09.cma;

public class LC096 {
    class Solution {
        public int numTrees(int n) {
            int m[] = new int[n + 1];
            m[0] = 1;
            for(int len = 1; len <= n; len++){
                int count = 0;
                for(int i = 1; i <= len; i ++){
                    count += m[i - 1] * m[len - i];
                }
                m[len] = count;
            }
            return m[n];
        }
    }
}
