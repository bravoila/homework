package com.techbow.homework.y2021.m09.cma;

public class LC542 {
    class Solution {
        private static final int[][] DIRCTIONS = {{0,1},{0,-1},{1,0},{-1,0}};

        public int[][] updateMatrix(int[][] mat) {
            int row = mat.length;
            int col = mat[0].length;

            int[][] res = new int[row][col];
            Queue<Integer> queue = new LinkedList<>();
            // loadAllZeros
            for(int i = 0 ; i < row; i++){
                for(int j = 0; j < col; j ++ ){
                    if(mat[i][j] == 0){
                        queue.offer(i * col + j);
                    }
                    res[i][j] = 0;
                }
            }
            int minLen = 1;
            while(! queue.isEmpty()){
                int size = queue.size();
                while(size -- > 0){
                    int curr = queue.poll();
                    int i = curr/col, j = curr%col;
                    for(int[] dir: DIRCTIONS){
                        int ii = i + dir[0], jj = j + dir[1];
                        if(ii >= 0 && ii < row && jj>= 0 && jj< col && mat[ii][jj] == 1 && res[ii][jj] == 0){
                            queue.offer(ii*col + jj);
                            res[ii][jj] = minLen;
                        }
                    }
                }
                minLen ++;
            }
            return res;
        }
    }
}
