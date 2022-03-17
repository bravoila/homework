package com.techbow.homework.y2021.m09.cma;

public class LC300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> mylist = new ArrayList<>();
            int idx = 0;
            for(int num : nums){
                idx = binarySearch(mylist,num);
                if(idx < mylist.size()){
                    mylist.set(idx, num);
                }else{
                    // num比list里的元素都大
                    mylist.add(num);
                }
            }
            return mylist.size();
        }
        // 找大于等于target的最小值
        private int binarySearch(List<Integer> mylist, int target){
            int start = 0, med = 0, med_value = 0, end = mylist.size()-1;
            while(start <= end){
                med = start + (end - start)/2;;
                med_value = mylist.get(med);
                if(med_value == target){
                    return med;
                } else if(med_value > target){
                    end = med - 1;
                } else{
                    start = med + 1;
                }
            }
            return start;
        }
    }

//    dp
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int longest = 0;
            for (int c: dp) {
                longest = Math.max(longest, c);
            }

            return longest;
        }
    }
}
