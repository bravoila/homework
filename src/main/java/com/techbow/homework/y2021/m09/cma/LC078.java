package com.techbow.homework.y2021.m09.cma;

public class LC078 {
    // 分层的逻辑
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> sub = new ArrayList<Integer>();
            dfs(nums, 0, sub, res);
            return res;
        }

        private void dfs(int[] array, int index, List<Integer> sub, List<List<Integer>> res){
            // if(index > nums.length){
            //     return;
            // }
            res.add(new ArrayList(sub));

            for(int i = index; i < array.length; i++){
                sub.add(array[i]);
                dfs(array, i + 1, sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }

    // 取不取的逻辑
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> sub = new ArrayList<Integer>();
            dfs(nums, 0, sub, res);
            return res;
        }

        private void dfs(int[] array, int index, List<Integer> sub, List<List<Integer>> res){
            if(index == array.length){
                res.add(new ArrayList(sub));
                return;
            }

            // 取
            sub.add(array[index]);
            dfs(array, index + 1, sub, res);
            sub.remove(sub.size() - 1);
            // 不取
            dfs(array, index + 1, sub, res);

        }
    }
}
