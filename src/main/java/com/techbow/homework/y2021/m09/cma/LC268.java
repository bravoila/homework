package com.techbow.homework.y2021.m09.cma;

public class LC268 {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);

            // Ensure that n is at the last index
            if (nums[nums.length-1] != nums.length) {
                return nums.length;
            }
            // Ensure that 0 is at the first index
            else if (nums[0] != 0) {
                return 0;
            }

            // If we get here, then the missing number is on the range (0, n)
            for (int i = 1; i < nums.length; i++) {
                int expectedNum = nums[i-1] + 1;
                if (nums[i] != expectedNum) {
                    return expectedNum;
                }
            }

            // Array was not missing any numbers
            return -1;
        }
    }

// Binary serach

    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);

            int left = 0;
            int right = nums.length;
            int med = 0;

            if(nums[0] == 1) return 0;
            if(nums[right-1] == right-1) return right;

            while(left <= right){
                med = (left + right)/2;
                if(nums[med] == med){
                    left = med + 1;
                }else{
                    right = med - 1;
                }
            }
            return left;
        }
    }

// hashSet
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
}
