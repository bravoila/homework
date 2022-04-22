package com.techbow.homework.y2021.m09.cma;

public class LC240 {
    // 最优解
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0){
                return false;
            }

            int row = matrix.length - 1;
            int col = 0;

            while(row >= 0 && col < matrix[0].length){
                if(matrix[row][col] == target){
                    return true;
                } else if(matrix[row][col] < target){
                    col++;
                } else{
                    row--;
                }
            }
            return false;
        }
    }
    // binary search 斜着搜索
    class Solution {
        private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0){
                return false;
            }
            int left = start;
            int right = vertical ? matrix[0].length-1 : matrix.length-1;
            int med;

            while (left <= right) {
                med = (left + right)/2;
                if (vertical) { // searching a column
                    if (matrix[start][med] < target) {
                        left = med + 1;
                    } else if (matrix[start][med] > target) {
                        right = med - 1;
                    } else {
                        return true;
                    }
                } else { // searching a row
                    if (matrix[med][start] < target) {
                        left = med + 1;
                    } else if (matrix[med][start] > target) {
                        right = med - 1;
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            // an empty matrix obviously does not contain `target`
            if (matrix == null || matrix.length == 0) {
                return false;
            }

            // iterate over matrix diagonals
            int shorterDim = Math.min(matrix.length, matrix[0].length);
            for (int i = 0; i < shorterDim; i++) {
                boolean verticalFound = binarySearch(matrix, target, i, true);
                boolean horizontalFound = binarySearch(matrix, target, i, false);
                if (verticalFound || horizontalFound) {
                    return true;
                }
            }
            return false;
        }
    }
}
