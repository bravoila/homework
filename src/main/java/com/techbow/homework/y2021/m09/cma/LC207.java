package com.techbow.homework.y2021.m09.cma;

public class LC207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            int[] status = new int[numCourses];

            for(int cur = 0; cur < numCourses; cur++){
                if(dfs(graph, cur, status)){
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(HashMap<Integer, List<Integer>> graph, int cur, int[] status){
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
                    if(dfs(graph, next, status)){
                        return true;
                    }
                }
            }
            status[cur] = 2;//ed
            return false;
        }
        //O(m+n)
    }
}
