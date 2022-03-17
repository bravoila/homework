package com.techbow.homework.y2021.m09.cma;

public class LC015 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++){
                if(i != 0 && nums[i - 1] == nums[i]){// nums[i]有重复
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;

                while(left < right){
                    if(nums[left] + nums[right] < 0 - nums[i]){
                        left++;
                    } else if(nums[left] + nums[right] > 0 - nums[i]){
                        right--;
                    } else{
                        res.add(new ArrayList<>(List.of(nums[left], nums[right], nums[i])));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]){// nums[left]和nums[left++]有重复
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
