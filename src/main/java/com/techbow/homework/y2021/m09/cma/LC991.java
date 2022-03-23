package com.techbow.homework.y2021.m09.cma;

public class LC991 {
    //Math
    class Solution {
        public int brokenCalc(int startValue, int target) {
            int count = 0;
            while(target > startValue){
                count++;
                if(target % 2 == 1){
                    target++;
                } else{
                    target /= 2;
                }
            }
            return count + startValue - target;
        }
    }
    // BFS
    class Solution {
        public int brokenCalc(int startValue, int target) {
            if(startValue == target){
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(startValue);
            int minLen = 0;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();

                    if(cur == target){
                        return minLen;
                    }

                    int next1 = cur - 1;
                    queue.offer(next1);

                    int next2 = cur * 2;
                    queue.offer(next2);
                }
                minLen++;
            }
            return 0;
        }
    }
}
