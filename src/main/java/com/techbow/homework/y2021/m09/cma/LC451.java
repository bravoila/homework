package com.techbow.homework.y2021.m09.cma;

public class LC451 {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for(char c: s.toCharArray()){
                counts.put(c, counts.getOrDefault(c,0) + 1);
            }

            List<Character> characters = new ArrayList<>(counts.keySet());
//            Arrays.sort works for arrays which can be of primitive data type also.
//            Collections.sort() works for objects Collections like ArrayList, LinkedList, etc.
//            Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));
            Collections.sort(characters, (a, b) -> counts.get(b).compareTo(counts.get(a)));

            StringBuilder sb = new StringBuilder();
            for(char c: characters){
                int copies = counts.get(c);
                for(int i = 0; i < copies; i ++){
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
