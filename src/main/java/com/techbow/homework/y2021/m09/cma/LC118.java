package com.techbow.homework.y2021.m09.cma;

public class LC118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for(int rowNum = 1; rowNum < numRows; rowNum ++){
                List<Integer> currRow = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum - 1);

                currRow.add(1);

                for(int j = 1; j < rowNum; j ++){
                    currRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                currRow.add(1);

                triangle.add(currRow);

            }

            return triangle;

        }
    }
}
