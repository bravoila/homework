package com.techbow.homework.y2021.m09.cma;

public class LC059 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            dfs(matrix, n, 0, 1);
            return matrix;
        }

        private void dfs(int[][] matrix, int n, int offset, int count){
            if(n <= 0){
                return;
            }

            if(n == 1){
                matrix[offset][offset] = count;
                return;
            }

            for(int i = 0; i < n - 1;i++){
                matrix[offset][offset + i] = count;
                count++;
            }

            for(int i = 0; i < n - 1; i++){
                matrix[offset + i][offset + n - 1] = count;
                count++;
            }

            for(int i = 0; i < n - 1; i++){
                matrix[offset + n - 1][offset + n - 1 - i] = count;
                count++;
            }

            for(int i = 0; i < n - 1; i++){
                matrix[offset + n - 1 - i][offset] = count;
                count++;
            }

            dfs(matrix, n - 2, offset + 1, count);
        }
    }
}
