package com.techbow.homework.y2021.m09.cma;

public class LC071 {
    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<String>();
            String[] comp = path.split("/");

            for(String dirc : comp){
                if(dirc.equals(".") || dirc.isEmpty()){
                    continue;
                } else if(dirc.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else{
                    stack.add(dirc);
                }
            }

            StringBuilder res = new StringBuilder();
            for(String dir: stack){
                res.append("/");
                res.append(dir);
            }
            return res.length() > 0? res.toString(): "/";
        }
    }
}
