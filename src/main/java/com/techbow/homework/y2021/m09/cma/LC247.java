package com.techbow.homework.y2021.m09.cma;

public class LC247 {
    class Solution {
        public char[][] reversiblePairs = {
                {'0', '0'}, {'1', '1'},
                {'6', '9'}, {'8', '8'}, {'9', '6'}
        };

        public List<String> gSN(int n, int finalLength) {
            if (n == 0) {
// 0-digit strobogrammatic number is an empty string.是空字符串，但不是空（null），类似python [""]
                return new ArrayList<>(List.of(""));
            }

            if (n == 1) {
                // 1-digit strobogrammatic numbers.
                return new ArrayList<>(List.of("0", "1", "8"));
            }

            List<String> prevSN = gSN(n - 2, finalLength);
            List<String> currSN = new ArrayList<>();

            for (String pSN : prevSN) {
                for (char[] pair : reversiblePairs) {
                    // We can only append 0's if it is not first digit.
                    if (pair[0] != '0' || n != finalLength) {
                        currSN.add(pair[0] + pSN + pair[1]);
                    }
                }
            }
            return currSN;
        }

        public List<String> findStrobogrammatic(int n) {
            return gSN(n, n);
        }
    }
}
