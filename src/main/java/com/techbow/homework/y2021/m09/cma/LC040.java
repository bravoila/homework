package com.techbow.homework.y2021.m09.cma;

public class LC040 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
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
                dfs(candidates, i + 1, remain - candidates[i], comb, res);
                comb.remove(comb.size() - 1);
                // 前面sort了
                while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
            }
            return;
        }
    }
}
