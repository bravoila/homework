package com.techbow.homework.y2021.m09.cma;

public class LC127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(beginWord == null || endWord == null || wordList == null){
                return -1;
            }
            // HashSet<String> wordSet = new HashSet<>();
            // for(String word: wordList){
            //     wordSet.add(word);
            // }

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            HashSet wordSet = new HashSet(wordList);
            wordSet.remove(beginWord);

            int minLen = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- > 0){
                    String curr = queue.poll();
                    List<String> nexts = convert(curr, wordSet);
                    for(String next: nexts){
                        if(next.equals(endWord)){
//                         如果这写minLen++, 那么就是先retrun 再++，结果不对
                            return ++minLen;
                        }
                        if(wordSet.remove(next)){
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                }
                minLen++;
            }
            return 0;
        }

        private List<String> convert(String curr, HashSet<String> wordSet){
            List<String> nextList = new LinkedList<>();
            char[] cc = curr.toCharArray();
            for(int i = 0; i < cc.length; i++){
                char temp = cc[i];
                for(char ch ='a'; ch <='z'; ch++){
                    cc[i] = ch;
                    String str = String.valueOf(cc);
                    if(ch != temp && wordSet.contains(str)){
                        nextList.add(str);
                    }
                    cc[i] = temp;
                }
            }
            return nextList;
        }
    }
}
