package com.techbow.homework.y2021.m09.cma;

public class LC1047 {
    // 也可参考用stack， LC1209
    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();
            int sbLength = 0;
            for(char ch : s.toCharArray()){
                if(sbLength != 0 && ch == sb.charAt(sbLength - 1)){
                    sb.deleteCharAt(sbLength - 1);
                    sbLength--;
                } else{
                    sb.append(ch);
                    sbLength++;
                }
            }
            return sb.toString();
        }
    }
}
