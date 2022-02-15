package com.techbow.homework.y2021.m09.cma;

public class LC1100 {
    //类似LC567
    public int numKLenSubstrNoRepeats(String s, int k) {
        int count = 0;
        int slow = 0;
        int sLen = s.length();

        if(k > sLen || k > 26){
            return count;
        }

        int freq[] = new int[26];

        for(int i = 0; i < sLen; i++ ){
            freq[s.charAt(i) - 'a']++;

            while(freq[s.charAt(i) - 'a'] > 1){
                freq[s.charAt(slow) - 'a']--;
                slow++;
            }

            if(i - slow + 1 == k){
                count++;
                freq[s.charAt(slow) - 'a'] --;
                slow++;
            }
        }
        return count;
    }
}
