package com.techbow.homework.y2021.m09.cma;

public class LC200 {

    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;
            int count = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j ++){
                    if(grid[i][j] == '1'){
                        count ++;
                        visited(i, j, m, n, grid);
                    }
                }
            }
            return count;
        }

        private void visited(int i, int j, int m, int n, char[][] grid){
            if(i < 0 || j < 0 || i >= m || j >=n){
                return;
            }

            if(grid[i][j] == '1'){
                //    grid[i][j] = '0';变成大水球。改变原来的input, 建议改成无意义的量，这样之后可以复原
                grid[i][j] = 'Y';
                visited(i - 1, j, m, n, grid);
                visited(i, j - 1, m, n, grid);
                visited(i + 1, j, m, n, grid);
                visited(i, j + 1, m, n, grid);
            }
            return;
        }
    }


}
