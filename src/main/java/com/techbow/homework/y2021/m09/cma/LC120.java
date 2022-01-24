package com.techbow.homework.y2021.m09.cma;

public class LC120 {
//    DFS
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            Integer[][] dp = new Integer[triangle.size()][triangle.size()];
            return dfs(0,0, triangle, dp);
        }

        private int dfs(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
            int n = triangle.size();
            if (i == n) return 0;
            // 1
            if (dp[i][j] != null) return dp[i][j];


            int left = dfs(i + 1, j, triangle,dp);
            int right = dfs(i + 1, j + 1, triangle,dp);
            // 2
            dp[i][j] =  triangle.get(i).get(j) + Math.min(left, right);
            return dp[i][j];
        }

    }

// recursion + dp + pruning
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
//         因为要与null比较，所以要是Integer不能是int,an int is a primitive type and cannot be null
//         要么在最开始明确size （Integer[len][len]），要么在之后读的时候再明确size，如果不明确的话，dp[i]是null，dp[i][j]读不出来
            Integer[][] dp = new Integer[len][len];
            return recursion(triangle, 0, 0, dp);
        }

        private int recursion(List<List<Integer>> matrix, int i, int j, Integer[][] dp){
            if(i == matrix.size()){
                return 0;
            }
            // if(dp[i] == null){
            //     dp[i] = new Integer[matrix.get(i).size()];
            // }

            if(dp[i] != null && dp[i][j] != null){
                return dp[i][j];
            }

            int left = recursion(matrix, i + 1, j, dp);
            int right = recursion(matrix, i + 1, j + 1, dp);

            dp[i][j] =  matrix.get(i).get(j) + Math.min(left, right);

            return dp[i][j];
        }
    }



//    DP
//    1. Definition
//    2. Base Case/ Start
//    3. Induction Rule/ Function 状态转移方程
//    4. Termination
//    5. Optimization

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
//         dp[i][j] is the minimum path sum from (i,j) to bottom
            int len = triangle.size();
            int[][] dp = new int[len][len];

            for(int j = 0; j < len; j++){
                dp[len-1][j] = triangle.get(len-1).get(j);
            }

            for(int i = len-2; i >=0; i--){
                for(int j = 0; j <= i; j++){
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }
}
