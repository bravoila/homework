package com.techbow.homework.y2021.m09.cma;

public class LC258 {
    class Solution {
        public int addDigits(int num) {
            int digitalRoot = 0;
            while (num > 0) {
                digitalRoot += num % 10;
                num = num / 10;

                if (num == 0 && digitalRoot > 9) {
                    num = digitalRoot;
                    digitalRoot = 0;
                }
            }
            return digitalRoot;
        }
    }

    // 数学方法
    class Solution {
        public int addDigits(int num) {
            if (num == 0) return 0;
            if (num % 9 == 0) return 9;
            return num % 9;
        }
    }
}
