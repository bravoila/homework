package com.techbow.homework.y2021.m09.cma;

public class LC048 {
    class Solution {
        public void rotate(int[][] matrix) {
            //要采用拉的方式，不能采用推的方式。180度和270度都是要注意坐标的对应关系即可。
            helper(matrix, 0, matrix.length);
        }
        private void helper(int[][] matrix, int offset, int size){
            if(size <= 1) return;
            for(int i = 0; i < size-1; i++){
                int temp =  matrix[offset][offset+i];
                matrix[offset][offset + i] = matrix[offset + size -1 - i][offset];
                matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
                matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
                matrix[offset + i][offset + size - 1] = temp;
            }
            helper(matrix, offset + 1, size - 2);
        }

    }
}
