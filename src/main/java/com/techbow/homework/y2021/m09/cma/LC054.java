package com.techbow.homework.y2021.m09.cma;

public class LC054 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
//         c.c
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0) return res;

            dfs(matrix, 0, matrix.length, matrix[0].length, res);
            System.out.println(res);
            return res;
        }
        //     rowSize, colSize 就是用来描述矩阵大小的
        private void dfs(int[][] matrix, int offset, int rowSize, int colSize, List<Integer> res){
            System.out.println(offset +" "+ rowSize +" " + colSize +" " + res);

            if(rowSize == 1){
                for(int i = 0; i < colSize; i++){
                    res.add(matrix[offset][offset + i]);
                }
                return;
            }
            if(colSize == 1){
                for(int i = 0; i < rowSize; i++){
                    res.add(matrix[offset + i][offset]);
                }
                return;
            }

            if(rowSize == 0 || colSize == 0){
                return;
            }

            for(int i = 0; i < colSize - 1; i++){
                res.add(matrix[offset][offset + i]);
            }
            for(int i = 0; i < rowSize - 1; i++){
                res.add(matrix[offset + i][offset + colSize -1]);
            }
            for(int i = 0; i < colSize - 1; i++){
                res.add(matrix[offset + rowSize - 1][offset + colSize - 1 - i]);
            }
            for(int i = 0; i < rowSize - 1; i++){
                res.add(matrix[offset + rowSize - 1 - i][offset]);
            }

            dfs(matrix, offset + 1, rowSize - 2, colSize - 2, res);
        }
    }class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
//         c.c
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0) return res;

            dfs(matrix, 0, matrix.length, matrix[0].length, res);
            System.out.println(res);
            return res;
        }
        //     rowSize, colSize 就是用来描述矩阵大小的
        private void dfs(int[][] matrix, int offset, int rowSize, int colSize, List<Integer> res){
            System.out.println(offset +" "+ rowSize +" " + colSize +" " + res);

            if(rowSize == 1){
                for(int i = 0; i < colSize; i++){
                    res.add(matrix[offset][offset + i]);
                }
                return;
            }
            if(colSize == 1){
                for(int i = 0; i < rowSize; i++){
                    res.add(matrix[offset + i][offset]);
                }
                return;
            }

            if(rowSize == 0 || colSize == 0){
                return;
            }

            for(int i = 0; i < colSize - 1; i++){
                res.add(matrix[offset][offset + i]);
            }
            for(int i = 0; i < rowSize - 1; i++){
                res.add(matrix[offset + i][offset + colSize -1]);
            }
            for(int i = 0; i < colSize - 1; i++){
                res.add(matrix[offset + rowSize - 1][offset + colSize - 1 - i]);
            }
            for(int i = 0; i < rowSize - 1; i++){
                res.add(matrix[offset + rowSize - 1 - i][offset]);
            }

            dfs(matrix, offset + 1, rowSize - 2, colSize - 2, res);
        }
    }
}
