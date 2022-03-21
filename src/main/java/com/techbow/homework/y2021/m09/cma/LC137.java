package com.techbow.homework.y2021.m09.cma;

public class LC137 {
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bitCount = new int[32];
            for(int n : nums){
                for(int i = 0 ; i < 32; i++){// bitCount就是上图0774
                    int val = n & 1;//取第i位bit值
                    bitCount[i] += val;
                    n = n >> 1;//n右移
                }
            }
            int res = 0;
            for(int i = 0; i < 32; i++){
                if(bitCount[i] % 3 != 0){//此bit是1
                    res += 1<<i;//还原成10进制
                }
            }
            return res;
        }
    }
}
