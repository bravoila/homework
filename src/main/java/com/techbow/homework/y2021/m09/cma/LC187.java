package com.techbow.homework.y2021.m09.cma;

public class LC187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int L = 10, n = s.length();
            HashSet<String> seen = new HashSet(), output = new HashSet();

            // iterate over all sequences of length L
            for (int start = 0; start < n - L + 1; ++start) {
                String tmp = s.substring(start, start + L);
                if (seen.contains(tmp)) output.add(tmp);
                seen.add(tmp);
            }
            return new ArrayList<String>(output);
        }
    }
    // 比特优化

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            if(s == null || s.length() < 10){
                return res;
            }
            HashMap<Integer, Boolean> map = new HashMap<>();
            int len = s.length();
            int key = 0;

            for(int i = 0; i < len; i++){
                char ch = s.charAt(i);
                key = (key<<= 2) & 0xfffff | convert(ch);
                if(i < 9){
                    continue;
                }
                Boolean val = map.get(key);
                if(val != null){ //s0
                    if(!val){//s1
                        res.add(s.substring(i - 9, i + 1)); // [i - 9, i + 1) len = i+1 - (i-9) = 10
                    }
                    map.put(key, true);
                } else{
                    map.put(key,false);
                }
            }
            return res;
        }

        private int convert(char c){
            switch(c){
                case 'A': return 0;
                case 'C': return 1;
                case 'G': return 2;
                case 'T': return 3;
                default: return -1;
            }
        }
    }
}
