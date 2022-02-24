package com.techbow.homework.y2021.m09.cma;

public class LC132 {
    class Solution {
        public int minCut(String s) {
            int slen = s.length();
            int[] dp = new int[slen+ 1];
            boolean m[][] = new boolean[slen][slen];

            for(int i = slen - 1; i >= 0; i--){
                dp[i] = slen - i;
                for(int j = i; j < slen; j++){
                    if(i == j || s.charAt(i) == s.charAt(j) && (j == i + 1 || m[i + 1][j - 1])){
                        dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                        m[i][j] = true;
                    }
                }
            }
            return dp[0] - 1;
        }
    }
}
