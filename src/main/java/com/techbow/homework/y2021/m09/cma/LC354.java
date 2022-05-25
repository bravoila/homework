package com.techbow.homework.y2021.m09.cma;

public class LC354 {
    // DP O(n^2)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int res = 1;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }

    // DP + Binary search
    class Solution {
        public int maxEnvelopes(int[][] E) {
            Arrays.sort(E, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int[] dp = new int[E.length];
            int ans = 0;
            for (int[] env : E) {
                int height = env[1];
                int left = Arrays.binarySearch(dp, 0, ans, height);
                if (left < 0) left = -left - 1;
                if (left == ans) ans++;
                dp[left] = height;
            }
            return ans;
        }
    }
}
