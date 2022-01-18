package com.techbow.homework.y2021.m09.cma;

public class LC378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int rows = matrix.length, columns = matrix[0].length;

            //to keep track of visited cells
            boolean[][] visited = new boolean[rows][columns];

            //MinHeap
            Queue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
            pq.offer(new int[]{matrix[0][0], 0, 0});
            while(!pq.isEmpty()) {
                //retrieving the cell with the smallest value
                int[] cur = pq.poll();
                int i = cur[1];
                int j = cur[2];
                int val = cur[0];
                //once we polled kth smallest element from the queue we can simply return it
                if (--k == 0) {
                    return val;
                }

                //adding right cell to the queue if it has not been visited yet
                if (j < columns - 1 && !visited[i][j + 1]) {
                    pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
                    //marking the cell as visited
                    visited[i][j + 1] = true;
                }
                //adding bottom cell to the queue if it has not been visited yet
                if (i < rows - 1 && !visited[i + 1][j]) {
                    pq.offer(new int[]{matrix[i + 1][j], i + 1, j});
                    //marking the cell as visited
                    visited[i + 1][j] = true;
                }
            }

            return -1;
        }
    }
}
