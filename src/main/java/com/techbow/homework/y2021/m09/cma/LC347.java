package com.techbow.homework.y2021.m09.cma;

public class LC347 {
    class Solution {
        // 类似LC692
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> dict = new HashMap<>();
            // 不能这么写，因为int是premitive的，每次get出来地址不一样，所以value永远是1
            // for(int num : nums){
            //     if(!dict.containsKey(nums)){
            //         dict.put(num, 1);
            //     } else{
            //         dict.put(num, dict.get(num) + 1);
            //     }
            // }
            // System.out.print(dict);
            for (int n: nums) {
                dict.put(n, dict.getOrDefault(n, 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (n1,n2) -> dict.get(n1) - dict.get(n2));
            for(int key: dict.keySet()){
                pq.add(key);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            int[] res = new int[k];

            for(int i = 0; i < k; i++){
                res[i] = pq.poll();
            }

            return res;
        }
    }
}
