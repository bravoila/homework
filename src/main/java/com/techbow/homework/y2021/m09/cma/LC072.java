package com.techbow.homework.y2021.m09.cma;

public class LC072 {
    class Solution {
        public int minDistance(String word1, String word2) {
//         c.c
            if(word1 == null || word2 == null) return -1;
            if(word1.length() == 0) return word2.length();
            if(word2.length() == 0) return word1.length();

            if (word1 == null || word1.length() == 0 ) {
                if (word2 == null)  return 0;
                return word2.length();
            }
            if (word2 == null || word2.length() == 0 ) {
                if (word1 == null) return 0;
                return word1.length();
            }
//         这个表表示的是S1变S2
//         e.g. S1取e, S2取c含义是S1 = abe, S2= abc
//         S1(abe)转表中的值步后变成S2(abc)
//         可以得到dp equaiton:
// 左上角                 dp[i][j] = dp[i - 1][j - 1] if S1.charAt(i) = S2.charAt(j)
// 左上角，左，上的最小值加1 dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            //         如果不确定，就按leetcode答案的那个equation写
        /*       S2,j   a   b   c   d   e  f
        // 	      |空   1   2   3   4  5   6
        -------------------------------------
        // S1,i 空| 0 | 1   2   3  4   5   6
                  ---------------------------
        // a    1 | 1 | 0   1   2  3   4   5
        // b    2 | 2 | 1   0   1  2   3   4
        // e    3 | 3 | 2   1   1  2   2   3
        // f    4 | 4 | 3   2   2  2   3   2
        // 分4块区域想， 左上，左，上，右下; */

//         初始值
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
//         dp
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <=n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }

    class Solution {
        public int minDistance(String word1, String word2) {
//         c.c
            if(word1 == null || word2 == null) return -1;
            if(word1.length() == 0) return word2.length();
            if(word2.length() == 0) return word1.length();

            if (word1 == null || word1.length() == 0 ) {
                if (word2 == null)  return 0;
                return word2.length();
            }
            if (word2 == null || word2.length() == 0 ) {
                if (word1 == null) return 0;
                return word1.length();
            }

//         如果不确定，就按leetcode答案的那个equation写
        /*       S2,j   a   b   c   d  e  f
        // 	      |空   1   2   3   4  5   6
        -------------------------------------
        // S1,i 空| 0 | 1   2   3  4   5   6
                  ---------------------------
        // a    1 | 1 | 0   1   2  3   4   5
        // b    2 | 2 | 1   0   1  2   3   4
        // e    3 | 3 | 2   1   1  2   2   3
        // f    4 | 4 | 3   2   2  2   3   2
        // 分4块区域想， 左上，左，上，右下; */

//         初始值
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
//         dp
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <=n; j++) {
                    int left = dp[i - 1][j] + 1;
                    int down = dp[i][j - 1] + 1;
                    int left_down = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        left_down += 1;
                    }
                    dp[i][j] = Math.min(Math.min(left_down, down), left) ;
                }
            }
            return dp[m][n];
        }
    }



}
