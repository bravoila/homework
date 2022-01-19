package com.techbow.homework.y2021.m09.cma;

public class LC078 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> sub = new ArrayList<Integer>();
            dfs(nums, 0, sub, res);
            return res;
        }

        private void dfs(int[] array, int index, List<Integer> sub, List<List<Integer>> res){

            res.add(new ArrayList(sub));

            for(int i = index; i < array.length; i++){
                sub.add(array[i]);
                dfs(array, i + 1, sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
