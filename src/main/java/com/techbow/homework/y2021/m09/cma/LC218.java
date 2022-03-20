package com.techbow.homework.y2021.m09.cma;

public class LC218 {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> res = new ArrayList<>();
            if(buildings.length == 0 || buildings[0].length == 0){
                return res;
            }

            List<EndPoint> endPoints = new ArrayList<EndPoint>();
            for(int[] b : buildings){
                endPoints.add(new EndPoint(b[0], b[2], false));
                endPoints.add(new EndPoint(b[1], b[2], true));
            }

            Collections.sort(endPoints);

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1,i2) -> i2 - i1);

            for(EndPoint ep : endPoints){
                if(!ep.isEnd){// left point
                    if(maxHeap.isEmpty() || ep.height > maxHeap.peek()){
                        res.add(Arrays.asList(ep.x, ep.height));
                    }
                    maxHeap.offer(ep.height);
                } else{
                    maxHeap.remove(ep.height);
                    if(maxHeap.isEmpty() || ep.height > maxHeap.peek()){
                        res.add(Arrays.asList(ep.x, maxHeap.isEmpty()? 0: maxHeap.peek()));
                    }
                }
            }
            return res;
        }
    }

    class EndPoint implements Comparable<EndPoint>{
        public int x;
        public int height;
        public boolean isEnd;

        public EndPoint(int x, int height, boolean isEnd){
            this.x = x;
            this.height = height;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(EndPoint that){
            if(this.x != that.x){
                return this.x - that.x;
            } else{
                if(!this.isEnd && !that.isEnd){ //both left: first high
                    return that.height - this.height;
                } else if(this.isEnd && that.isEnd){ //both right: first low
                    return this.height - that.height;
                } else{ // one left, one right : first left point
                    return this.isEnd? 1: -1;
                }
            }
        }
    }
}
