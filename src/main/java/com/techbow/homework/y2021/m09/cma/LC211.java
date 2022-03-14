package com.techbow.homework.y2021.m09.cma;

public class LC211 {
    class TrieNode{
        public char ch;
        public TrieNode[] children;
        public boolean isWord = false;

        public TrieNode(char ch){
            children = new TrieNode[26];
            this.ch = ch;
        }
    }

    class WordDictionary {
        private TrieNode root = new TrieNode('\0');

        public WordDictionary() {
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return dfs(root, word, 0);
        }

        private boolean dfs(TrieNode curr, String word, int index){
            int len = word.length();
            if(curr == null){
                return false;
            }
            if(len == index){
                return curr.isWord;
            }

            char ch = word.charAt(index);
            if(ch != '.'){
                return dfs(curr.children[ch - 'a'], word, index + 1);
            } else{
                for(TrieNode next : curr.children){
                    if(dfs(next, word, index + 1)){
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
