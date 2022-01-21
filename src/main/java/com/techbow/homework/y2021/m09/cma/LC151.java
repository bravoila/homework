package com.techbow.homework.y2021.m09.cma;

public class LC151 {
    class Solution {
        public String reverseWords(String s) {
            // remove leading spaces
            s = s.trim();
            // split by multiple spaces
            List<String> wordList = Arrays.asList(s.split("\\s+")); //regex expression
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }
    }
}
