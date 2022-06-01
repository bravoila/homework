package com.techbow.homework.y2021.m09.cma;

public class L1197 {
    class Solution {
        private static final int[][] DIRCTIONS = {{2,1},{2,-1},{-2,1},{-2,-1},
                {1,2},{1,-2},{-1,2},{-1,-2}};
        public int minKnightMoves(int x, int y) {
            int level = 0;
            Queue<int[]> myqueue = new LinkedList<>();
            boolean[][] visited = new boolean[607][607];
            myqueue.offer(new int[]{0,0});

            while(!myqueue.isEmpty()){
                int size = myqueue.size();
                while(size-- > 0){
                    int[] cur = myqueue.poll();
                    // System.out.println(Arrays.toString(cur));
                    if(cur[0] == x && cur[1] == y){
                        return level;
                    }
                    for(int[] dir : DIRCTIONS){
                        int ii = cur[0] + dir[0];
                        int jj = cur[1] + dir[1];
                        //visited
                        // System.out.println(ii);
                        // System.out.println(jj);
                        if(!visited[ii + 302][jj + 302]){
                            visited[ii + 302][jj + 302] = true;
                            myqueue.offer(new int[]{ii,jj});
                        }
                    }
                }
                level++;
            }
            return level;
        }
    }
}
