package com.techbow.homework.y2021.m09.cma;

public class LC039 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, 0, target, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] candidates, int ind, int remain, List<Integer> comb, List<List<Integer>> res){
            if(remain == 0){
                res.add(new ArrayList<>(comb));
                return;
            }
            if(remain < 0){
                return;
            }

            for(int i = ind; i < candidates.length; i++){
                comb.add(candidates[i]);
                dfs(candidates, i, remain - candidates[i], comb, res);
                comb.remove(comb.size() - 1);
            }
            return;
        }
    }
}
