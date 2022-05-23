package com.techbow.homework.y2021.m09.cma;

public class LC063 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // cc
            if(obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
                return 0;
            }
            int res = 0;
            int rLen = obstacleGrid.length;
            int cLen = obstacleGrid[0].length;

            Integer[][] mem = new Integer[rLen + 1][cLen + 1];
            return dfs(obstacleGrid, 0, 0, mem);
        }

        private int dfs(int[][] grid, int i, int j, Integer[][] mem){
            if(i == grid.length -1 && j == grid[0].length - 1 && grid[i][j] == 0){
                return 1;
            }

            if(i>= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 0){
                if(mem[i+1][j] == null) mem[i+1][j] = dfs(grid, i + 1, j, mem);
                if(mem[i][j+1] == null) mem[i][j+1] = dfs(grid, i, j + 1, mem);
                return mem[i+1][j] + mem[i][j+1];
            }

            return 0;
        }
    }
// 下面的更快
    class Solution {
        Integer[][] matrix;
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // cc
            if(obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
                return 0;
            }
            matrix = new Integer[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
            return dfs(obstacleGrid, 0, 0);
        }

        private int dfs(int[][] grid, int i, int j) {
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
                return 0;
            }

            if(i == grid.length - 1 && j == grid[0].length - 1) {
                return 1;
            }
            if(matrix[i+1][j] == null) matrix[i+1][j] = dfs(grid, i + 1, j);
            if(matrix[i][j+1] == null) matrix[i][j+1] = dfs(grid, i, j + 1);
            return matrix[i+1][j] + matrix[i][j+1];
        }
    }


}
