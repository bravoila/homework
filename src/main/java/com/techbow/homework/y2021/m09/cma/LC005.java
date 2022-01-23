package com.techbow.homework.y2021.m09.cma;

public class LC005 {
//    陪练
    class Solution {
        public String longestPalindrome(String s){
            if(s == null || s.length() == 0) return s;
            int left = 0;
            int right = 0;//left 和right是用来表示最长的palindrom的头尾
            int l, r;
            for(int i = 0; i < s.length(); i++){
                l = i;
                r = i;
//             连续字符串
                while(r+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                    r++;
                    i++;
                }
//             中心开花，两面拓展
                while(l > 0 && r < s.length() - 1 && s.charAt(l-1) == s.charAt(r+1)){
                    l--;
                    r++;
                }
//             检查长度
                if(r - l > right - left){
                    right = r;
                    left = l;
                }
            }
            return s.substring(left, right+1);
        }
    }
//    加强

    class Solution {
        public String longestPalindrome(String s){
            if(s == null || s.length() == 0) return null;
            String res = "";
            for (int i = 0; i < s.length(); i++){
//             奇数，中心开hua
                String str = search(s, i, i);
                if(str.length() > res.length()){
                    res = str;
                }
//             偶数，两个相等的case
                str = search(s, i, i+1);
                if(str.length() > res.length()){
                    res = str;
                }
            }
            return res;
        }

        private String search(String s, int left, int right){
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }

    }
}
