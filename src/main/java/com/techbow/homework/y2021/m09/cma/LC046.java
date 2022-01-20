package com.techbow.homework.y2021.m09.cma;

public class LC046 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> numList = new ArrayList<Integer>();
            for(int num : nums){
                numList.add(num);
            }

            dfs(numList, 0, res);

            return res;
        }

        private void dfs(List<Integer> array, int index, List<List<Integer>> res){
            // base case
            if(index == array.size() - 1){
                res.add(new ArrayList<Integer>(array));
                return;
            }

            for(int i = index; i < array.size(); i ++){

                Collections.swap(array, index, i);
                dfs(array, index + 1, res);
                Collections.swap(array, index, i);
            }
        }
    }
}
