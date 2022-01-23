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

//基于LC119的解法
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(new ArrayList<>(row));

            for(int i = 0; i < numRows - 1; i ++){
                for(int j = i; j > 0; j--){
                    row.set(j, row.get(j) + row.get(j - 1));
                }
                row.add(1);
                triangle.add(new ArrayList<>(row));
            }

            return triangle;

        }
    }
}
