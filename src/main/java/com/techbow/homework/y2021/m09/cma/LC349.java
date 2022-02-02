package com.techbow.homework.y2021.m09.cma;

public class LC349 {
//    use built in function

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            for (Integer n : nums1) set1.add(n);
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (Integer n : nums2) set2.add(n);

            set1.retainAll(set2);

            int [] output = new int[set1.size()];
            int idx = 0;
            for (int s : set1) output[idx++] = s;
            return output;
        }
    }

//    not use built in function
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> inter = new HashSet<>();


            for(int num1: nums1){
                set1.add(num1);
            }

            for(int num2: nums2){
                if(set1.contains(num2)){
                    inter.add(num2);
                }
            }

            int[] res = new int[inter.size()];
            int i = 0;
            for(int num: inter){
                res[i] = num;
                i++;
            }
            return res;
        }
    }

//    two pointer
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    set.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int[] result = new int[set.size()];
            int k = 0;
            for (Integer num : set) {
                result[k++] = num;
            }
            return result;
        }
    }

}
