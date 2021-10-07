package com.techbow.homework.y2021.m09.cma;

public class LC056 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length <= 1){
                return intervals;
            }
            List<int[]> res = new ArrayList<>();
            int[] newInterval = intervals[0];

            Arrays.sort(intervals, (i1,i2) -> i1[0] - i2[0]);

            int[] prev = intervals[0];
            for(int[] interval: intervals){
                if(prev[1] < interval[0]){
                    res.add(prev);
                    prev = interval;
                } else{
                    prev[1] = Math.max(interval[1],prev[1]);
                }
            }
            res.add(prev);
            return res.toArray(new int[res.size()][]);
        }
    }
}
