package com.techbow.homework.y2021.m09.cma;

public class LC692 {class Solution {
    // 类似LC347
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> dict = new HashMap<>();
        for(String s: words){
            dict.put(s, dict.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (n1,n2) ->
                        // {
                        //     if(!dict.get(n1).equals(dict.get(n2))){
                        //         return dict.get(n1) - dict.get(n2);
                        //     } else{
                        //         System.out.println("Dfds");
                        //         return n2.compareTo(n1);
                        //     }
                        // }
                        dict.get(n1).equals(dict.get(n2))? n2.compareTo(n1) : dict.get(n1) - dict.get(n2)
        );

        for(String key : dict.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.reverse(res);
        return res;
    }
}
}
