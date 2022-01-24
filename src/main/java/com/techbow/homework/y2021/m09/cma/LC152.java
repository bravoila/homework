package com.techbow.homework.y2021.m09.cma;

public class LC152 {
    class Solution {
        public int maxProduct(int[] nums) {
                /*
        由于负数的存在，使得在loop的过程中，需要保持两个数，一个是当前遇到的最大值，一个是当前遇到的最小值。因为如果下一个是负数的话，那么通过和
        当前的最小值相乘，仍有机会成为最大值。而当前值为最大的话，和负数相乘，就会变成最小值。
        1. 计算max[i]的时候有三个途径，一是如果max[i-1]为负数，当前nums[i]也为负数；二是两者都为正数；再者就是nums[i]自己本身是最大值
        2. min[i]同样的思路
        3. 在每次更新的过程中，还要更新result
        */
            if(nums == null || nums.length == 0) return 0;
            int[] max = new int[nums.length];
            int[] min = new int[nums.length];
            max[0] = nums[0];
            min[0] = nums[0];
            int res = max[0];
            for(int i = 1; i < nums.length; i++) {
                max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1]*nums[i]), nums[i]);
                min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1]* nums[i]), nums[i]);
                res = Math.max(res, max[i]);
            }
            return res;
        }
    }
}
