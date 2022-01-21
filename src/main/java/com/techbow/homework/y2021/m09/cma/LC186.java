package com.techbow.homework.y2021.m09.cma;

public class LC186 {

//    reverse the whole string and then reverse words by words
    class Solution {
        public void reverseWords(char[] str) {
            if(str == null || str.length == 0) return;

            reverse(str, 0, str.length - 1);

            int start = 0;
            for(int end = 0; end <= str.length; end++) {
                if(end == str.length || str[end] == ' ') {
                    reverse(str, start, end-1);
                    start = end + 1;
                }
            }
        }

        private void reverse(char[] arr, int start, int end) {
            while(start < end) {
                char temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
    }
}
