package com.techbow.homework.y2021.m09.cma;

public class LC1510 {
    class Solution {
        public boolean winnerSquareGame(int n) {
//         要有缓存，来存储之前计算过的值
            HashMap<Integer, Boolean> cache = new HashMap<>();
            cache.put(0, false);
            return dfs(cache, n);
        }

        public static boolean dfs(HashMap<Integer, Boolean> cache, int remain) {
            if (cache.containsKey(remain)) {
                return cache.get(remain);
            }
            int sqrt_root = (int) Math.sqrt(remain);
            for (int i = sqrt_root; i >= 1; i--) {
                // if there is any chance to make the opponent lose the game in the next round,
                // then the current player will win.
                if (!dfs(cache, remain - i * i)) {
                    cache.put(remain, true);
                    return true;
                }
            }
            cache.put(remain, false);
            return false;
        }
    }
}
