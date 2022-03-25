package com.techbow.homework.y2021.m09.cma;

public class LC1029 {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            // 按两者差值排序
            Arrays.sort(costs, (o1, o2) -> {return o1[0] - o1[1] - (o2[0] - o2[1]);});

            int total = 0;
            int n = costs.length /2;
            for(int i = 0; i < n; i++){
                total += costs[i][0] + costs[i+n][1];
            }

            return total;
        }
    }
}
