package com.techbow.homework.y2021.m09.cma;

public class LC134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            int start = len;
            int end = 0;
            int sum = 0;
            while(end < start){
                if(sum >= 0){
                    // 向前开
                    sum += gas[end] - cost[end];
                    end++;
                } else{// 如果前面开不到，起始往前
                    start--;
                    sum += gas[start] - cost[start];
                }
            }
            return sum>=0? start%len : -1;
        }
    }
}
