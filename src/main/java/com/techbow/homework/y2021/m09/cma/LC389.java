package com.techbow.homework.y2021.m09.cma;

public class LC389 {
//    sort
    class Solution {
        public char findTheDifference(String s, String t) {

            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            char[] t1 = t.toCharArray();
            Arrays.sort(t1);

            int p1;
            for(p1 = 0; p1 < s.length(); p1++){
                if(s1[p1] != t1[p1]){
                    return t1[p1];
                }
            }
            return t1[p1];
        }
    }
//    Bit
    class Solution {
        public char findTheDifference(String s, String t) {

            // Initialize ch with 0, because 0 ^ X = X
            // 0 when XORed with any bit would not change the bits value.
            char ch = 0;

            // XOR all the characters of both s and t.
            for (int i = 0; i < s.length(); i += 1) {
                ch ^= s.charAt(i);
            }
            for (int i = 0; i < t.length(); i += 1) {
                ch ^= t.charAt(i);
            }

            // What is left after XORing everything is the difference.
            return ch;
        }
    }
}
