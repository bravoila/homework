package com.techbow.homework.y2021.m09.cma;

public class LC151 {
    //S1
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
    // S2
    class Solution {
        public String reverseWords(String s) {
            if(s == null){
                return null;
            }

            int n = s.length();
            char[] a = s.toCharArray();

            // step 1. reverse the whole string
            reverse(a, 0, n - 1);
            // step 2. reverse each word
            reverseWords(a, n);
            // step 3. clean up spaces
            return cleanSpaces(a, n);
        }

        // reverse a[] from a[i] to a[j]
        private void reverse(char[] array, int start, int end){
            while(start <= end){
                char tmp = array[start];
                array[start++] = array[end];
                array[end--] = tmp;
            }
        }

        private void reverseWords(char[] a, int n){
            int i = 0;
            int j = 0;
            while (i < n) {
                while (i < j || i < n && a[i] == ' ') i++; // skip spaces
                while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
                reverse(a, i, j - 1);                      // reverse the word
            }
        }

        // trim leading, trailing and multiple spaces
        private String cleanSpaces(char[] a, int n) {
            int i = 0, j = 0;

            while (j < n) {
                while (j < n && a[j] == ' ') j++;             // skip spaces
                while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
                while (j < n && a[j] == ' ') j++;             // skip spaces
                if (j < n) a[i++] = ' ';                      // keep only one space
            }

            return new String(a).substring(0, i);
        }
    }

}
