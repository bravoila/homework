package com.techbow.homework.y2021.m09.cma;

public class LC047 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            List<Integer> array = new ArrayList<Integer>(nums.length);
            for(int i : nums){
                array.add(i);
            }
            dfs(array, result, 0);
            return result;
        }

        private void dfs(List<Integer> array, List<List<Integer>> result, int index) {
            if (index == array.size()) {
                result.add(new ArrayList<Integer>(array));
                return;
            }
            Set<Integer> set = new HashSet<>(); //不能global在clear， 如果那样以为dfs反值就没了
            for (int i = index; i < array.size(); i++) {
                if(set.add(array.get(i))){ // compare array[i] vs array[i-1] // 跳叉，有问题,需要 并且得是另一类搜索树
                    Collections.swap(array, index, i);
                    dfs(array, result, index + 1);
                    Collections.swap(array, index, i);
                }
            }
        }
    }
}
