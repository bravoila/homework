package com.techbow.homework.y2021.m09.cma;

public class LC286 {
    class Solution {
        private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};

        public void wallsAndGates(int[][] rooms) {
            if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0){
                throw new IllegalArgumentException();
            }
            Queue<Integer> queue = new LinkedList<>();
            // LoadALLGates(rooms, queue)
            int row = rooms.length;
            int col = rooms[0].length;
            int idx = 0;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(rooms[i][j] == 0){
                        idx = i * col + j;
                        queue.offer(idx);
                    }
                }
            }

            int minLen = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size -- > 0){
                    int curr = queue.poll();
                    int i = curr/col;
                    int j = curr%col;
                    for(int[] dir:DIRECTIONS){
                        int ii = i + dir[0], jj = j + dir[1];
                        if(ii >=0 && ii < row && jj >= 0 && jj< col && rooms[ii][jj] == Integer.MAX_VALUE){
                            queue.offer(ii*col + jj);
                            rooms[ii][jj] = minLen;
                        }

                    }
                }
                minLen ++;
            }

        }
//     constant
    }
}
