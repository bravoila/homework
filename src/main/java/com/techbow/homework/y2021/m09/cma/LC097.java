package com.techbow.homework.y2021.m09.cma;

public class LC097 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int slen1 = s1.length();
            int slen2 = s2.length();
            int slen3 = s3.length();

            if(slen1 + slen2 != slen3){
                return false;
            }

            boolean[][] dp = new boolean[slen1+1][slen2+1];
            dp[0][0] = true;
            // 初始化 “”和s3中的match的情况
            // dp[i][0] = s3.subString(0,i).equals(s1.subString(0,i));
            // dp[0][j] = s3.subString(0,j).equals(s1.subString(0,j));
            for(int i = 0; i < slen1; i++){
                dp[i + 1][0] = dp[i][0] &&(s1.charAt(i) == s3.charAt(i));
            }

            for(int j = 0; j < slen2; j++){
                dp[0][j + 1] = dp[0][j] &&(s2.charAt(j) == s3.charAt(j));
            }

            for(int i = 0; i < slen1; i++){
                for(int j = 0; j < slen2; j++){
                    int k = i + j + 1;
                    if(s1.charAt(i) == s3.charAt(k)){
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                    if(s2.charAt(j) == s3.charAt(k)){
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i + 1][j];
                    }
                }
            }
            return dp[slen1][slen2];
        }
    }
}
