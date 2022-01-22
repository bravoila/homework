package com.techbow.homework.y2021.m09.cma;

public class LC028 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) return -1;

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
            return -1;
        }
    }


// Robin Karb Solution Java -> O(n)
    class Solution {
        public int strStr(String s1, String s2) {
            if(s1 == null || s1.length() == 0 && s2 == null || s2.length() == 0) return 0;
            if(s1 == null || s1.length() == 0) return -1;
            if(s1.length() < s2.length()) return -1;

            // sliding window;
            long hashCode = 0; // avoid overflow;
            char[] str2 = s2.toCharArray();
            char[] str1 = s1.toCharArray();
            int n = str2.length-1;
            for(char a : str2){
                hashCode += Math.pow(26,n) * (a -'a');
                n--;
            }

            long checkSum = 0; // avoid overflow;
            n = str2.length - 1;

            for(int j = 0; j < str2.length; j++){
                checkSum += (long)Math.pow(26, n) * (str1[j] - 'a');
                n--;
            }
            if(checkSum == hashCode) return 0;
            n = str2.length;
            for(int i = str2.length; i <= str1.length - 1;i++){
                checkSum = (checkSum - (long)Math.pow(26,n - 1) * (str1[i - n] - 'a' )) * 26 + (str1[i] - 'a' );
                if(checkSum == hashCode) return i - str2.length + 1;
            }
            return -1;
        }
    }
}
