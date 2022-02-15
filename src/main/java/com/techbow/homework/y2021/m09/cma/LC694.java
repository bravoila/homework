package com.techbow.homework.y2021.m09.cma;

public class LC694 {
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            HashSet<String> set = new HashSet<>();

            for(int i = 0 ; i < grid.length; i ++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        StringBuilder key = new StringBuilder();
                        dfs(grid, i, j, visited, key , 's');
                        set.add(key.toString());
                    }
                }
            }
            return set.size();
        }

        private void dfs(int[][] matrix, int i, int j, boolean[][] visited, StringBuilder key, char dir){
            if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length|| visited[i][j] || matrix[i][j] == 0){
                return;
            }
            visited[i][j] = true;
            key.append(dir);

            dfs(matrix, i, j + 1, visited, key, 'r');
            dfs(matrix, i + 1, j, visited, key, 'd');
            dfs(matrix, i, j - 1, visited, key, 'l');
            dfs(matrix, i - 1, j, visited, key, 'u');
            //顺着顺序可能一样，但是backtracking顺序不一样
            key.append('b');

        }
    }
}
