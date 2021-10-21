package com.techbow.homework.y2021.m09.cma;

public class LC119 {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            for(int i = 0; i < rowIndex; i++){
                for(int j = i; j > 0 ; j--){
                    currRow.set(j, currRow.get(j) + currRow.get(j - 1));
                    System.out.println(currRow);
                }
                currRow.add(1);
            }

            return currRow;
        }
    }
}
