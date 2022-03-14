package com.techbow.homework.y2021.m09.cma;

public class LC208 {
    class TrieNode {
        public char val;
        // 如果用的是ASCII，用其他的可能就要用HashMap
        public boolean isWord;
        public TrieNode[] next = new TrieNode[256];
        public TrieNode() {}
        TrieNode(char ch){
            this.val = ch;
            this.next = new TrieNode[256];
            this.isWord = false;
        }
    }

    public class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                //if(next == null){
                // next = new TrieNode(ch);--> 错误，这样会new一个新的，跟原来的trie脱节了
                //}
                if(curr.next[ch] == null){
                    curr.next[ch] = new TrieNode(ch);
                }
                curr = curr.next[ch];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.next[ch] == null) return false;
                curr = curr.next[ch];
            }
            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char ch: prefix.toCharArray()){
                if(curr.next[ch] == null) return false;
                curr = curr.next[ch];
            }
            return true;
        }
    }
}
