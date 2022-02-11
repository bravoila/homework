package com.techbow.homework.y2021.m09.cma;

public class LC0567 {
    //自己写的 sort
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();

            if(len1 > len2){
                return false;
            }

            char[] charS1 = s1.toCharArray();
            char[] charS2 = s2.toCharArray();

            Arrays.sort(charS1);

            for(int i = 0; i < len2 - len1 + 1; i++){
                char[] temp = Arrays.copyOfRange(charS2,i,i+len1);
                Arrays.sort(temp);
                if(Arrays.equals(temp, charS1)){
                    return true;
                }
            }
            return false;
        }
    }

    // String可以直接sort
    public class Solution {
        public boolean checkInclusion(String s1, String s2) {
            s1 = sort(s1);
            for (int i = 0; i <= s2.length() - s1.length(); i++) {
                if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                    return true;
            }
            return false;
        }

        public String sort(String s) {
            char[] t = s.toCharArray();
            Arrays.sort(t);
            return new String(t);
        }
    }
// permutatation  sliding window数词频 类似LC438 anagrams 找字谜
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();

            if(len1 > len2){
                return false;
            }

            int[] sarray1 = new int[26];
            int[] sarray2 = new int[26];

            for(int i = 0; i < len1; i++){
                sarray1[s1.charAt(i) - 'a'] ++;
            }

            for(int j = 0; j < len2; j ++){
                sarray2[s2.charAt(j) - 'a'] ++;
                if(j >= len1){
                    sarray2[s2.charAt(j - len1) - 'a'] --;
                }
                if(Arrays.equals(sarray1, sarray2)){
                    return true;
                }
            }
            return false;
        }
    }
}
