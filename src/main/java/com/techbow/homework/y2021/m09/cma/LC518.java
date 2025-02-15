package com.techbow.homework.y2021.m09.cma;

public class LC518 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int x = coin; x <= amount; x++) {
                    dp[x] += dp[x - coin];
                }
            }
            return dp[amount];
        }
    }
}
