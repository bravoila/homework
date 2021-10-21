package com.techbow.homework.y2021.m09.cma;

public class LC417 {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> res = new ArrayList<>();
//         C.C
            if(heights == null || heights[0] == null || heights.length == 0 || heights[0].length == 0){
                return res;
            }
            int row = heights.length, col = heights[0].length;
            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            Queue<int[]> queue = new LinkedList<int[]>();
//         load pacific
            for(int i = 0; i < row; i++){
//             left
                queue.offer(new int[]{i,0});
                pacific[i][0] = true;
            }
// 注意不要让角上的点进两次
// 注意bfs, 第一次是pacific, atlantic ，第二次是 atlantic, pacific

            for(int j = 1; j < col; j++){
//             top
                queue.offer(new int[]{0,j});
                pacific[0][j] = true;
            }

            bfs(res, queue, pacific, atlantic, heights);

//         load atlantic
            for(int i = 0; i < row; i++){
//             right
                queue.offer(new int[]{i,col - 1});
                atlantic[i][col - 1] = true;
            }

            for(int j = 0; j < col - 1; j++){
//             bottom
                queue.offer(new int[]{row - 1,j});
                atlantic[row - 1][j] = true;
            }

            bfs(res, queue, atlantic, pacific, heights);

            return res;
        }

        private void bfs(List<List<Integer>> res, Queue<int[]> queue, boolean[][] selfSet, boolean[][] otherSet, int[][] heights){
            int row = heights.length, col = heights[0].length;
            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                if(otherSet[curr[0]][curr[1]]){
                    res.add(Arrays.asList(curr[0], curr[1]));
                }

                for(int[] dir: directions){
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if(i >= 0 && i < row && j >= 0 && j < col && heights[curr[0]][curr[1]] <= heights[i][j] && !selfSet[i][j]){
                        queue.offer(new int[]{i,j});
                        selfSet[i][j] = true;
                    }
                }
            }
        }
    }
}
