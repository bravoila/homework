package com.techbow.homework.y2021.m09.cma;

public class LC350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> res = new ArrayList<>();

            int i = 0;
            int j = 0;
            while(i < nums1.length && j < nums2.length){
                if(nums1[i] <  nums2[j]){
                    i ++;
                } else if (nums1[i] > nums2[j]){
                    j ++;
                } else{
                    res.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int k = res.size();
            int[] ans = new int[k];
            while(k > 0){
                ans[k - 1] = res.get(k - 1);
                k --;
            }
            return ans;
        }
    }
}
