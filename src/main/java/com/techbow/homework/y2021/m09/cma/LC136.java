package com.techbow.homework.y2021.m09.cma;

public class LC136 {
    class Solution {
        /**
         If we take XOR of zero and some bit, it will return that bit
         a ⊕ 0 = a

         If we take XOR of two same bits, it will return 0
         a ⊕ a = 0

         a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
         对所有元素做异或，如果有重复，就会低效变成0，最终剩下没有重复的
         **/
        public int singleNumber(int[] nums) {
            int num = 0;
            for(int eachNum : nums){
                num ^= eachNum;
                System.out.println(num);

            }
            return num;
        }
    }
}
