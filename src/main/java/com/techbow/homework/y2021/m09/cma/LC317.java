package com.techbow.homework.y2021.m09.cma;

public class LC317 {
    class Solution {
        public int shortestDistance(int[][] grid) {
//         C.C
            if(grid == null || grid.length == 0){
                return -1;
            }

            int row = grid.length;
            int col = grid[0].length;
            int cost[][] = new int[row][col];

            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 1){
                        bfs(grid, i, j, cost);
                    }
                }
            }
//         find smallest cost
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 0 && cost[i][j] > 0){
                        min = Math.min(cost[i][j], min);
                    }
                }
            }
            return min == Integer.MAX_VALUE?-1:min ;
        }

        private void bfs(int[][] grid, int x, int y, int[][] cost){
            int row = grid.length;
            int col = grid[0].length;

            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            boolean[][] visited = new boolean[row][col];

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(x*col + y);
            visited[x][y] = true;
            int minLen = 0;

            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- >0){
                    int curr = queue.poll();
                    int i = curr/col;
                    int j = curr%col;
                    cost[i][j] += minLen;

                    for(int[] dir:directions){
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if(ii >= 0 && ii < row && jj >=0 && jj < col && !visited[ii][jj] && grid[ii][jj] == 0){
                            queue.offer(ii*col + jj);
                            visited[ii][jj] = true;

                        }
                    }
                }
                minLen ++;
            }
//         防止一些永远无法到达的0，给出错误答案（无法到达的0 默认距离最小）
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 0 && !visited[i][j]){
                        grid[i][j] = 2;
                    }
                }
            }

        }
    }
}
