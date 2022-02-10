package com.techbow.homework.y2021.m09.cma;

public class Lc090 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums,0, path, res);
            return res;
        }
        private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res){
            res.add(new ArrayList<>(path));

            for(int i = idx; i < nums.length; i++){
                if (i != idx && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                dfs(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
