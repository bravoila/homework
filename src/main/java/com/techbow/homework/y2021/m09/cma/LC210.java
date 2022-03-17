package com.techbow.homework.y2021.m09.cma;

public class LC210 {
    class Solution {
        private int idx;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            this.idx = numCourses - 1;
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            // buildGraph
            for(int[] relation : prerequisites){
                // relation[0] depends on relation[1]

                if(graph.containsKey(relation[1])){
                    graph.get(relation[1]).add(relation[0]);
                    System.out.println(graph.get(relation[1]));
                } else{
                    List<Integer> nextCourse = new LinkedList<>();
                    nextCourse.add(relation[0]);
                    graph.put(relation[1], nextCourse);
                }
            }
            int[] path = new int[numCourses];
            int[] status = new int[numCourses];

            for(int cur = 0; cur < numCourses; cur++){
                if(dfs(graph, cur, status, path)){
                    return new int[0];
                }
            }
            return path;
        }

        private boolean dfs(HashMap<Integer, List<Integer>> graph, int cur, int[] status, int[] path){
            if(status[cur] == 1){//ing
                return true;
            }
            if(status[cur] == 2){//ed
                return false;
            }
            status[cur] = 1;//ing
            List<Integer> nexts = graph.get(cur);

            if(nexts != null){
                for(int next : nexts){
                    if(dfs(graph, next, status, path)){
                        return true;
                    }
                }
            }
            status[cur] = 2;//ed
            path[idx--] = cur;
            return false;
        }
        //O(m+n)
    }
}
