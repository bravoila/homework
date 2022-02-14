package com.techbow.homework.y2021.m09.cma;

public class Lc020 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] sChar = s.toCharArray();
        Stack<Character> mystack = new Stack();

        for(char ch : sChar){
            if(map.containsKey(ch)){
                mystack.push(ch);
            } else if(map.containsValue(ch)){
                if(mystack.isEmpty()){
                    return false;
                } else if (ch == map.get(mystack.peek())){
                    mystack.pop();
                } else{
                    return false;
                }
            }
        }
        return mystack.isEmpty();
    }
}
