package com.techbow.homework.y2021.m09.cma;

public class LC004 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums2.length<nums1.length) return findMedianSortedArrays(nums2,nums1);
            int n1=nums1.length , n2=nums2.length;
            int lo=0,hi=n1;
            while(lo<=hi){
                int cut1=(lo+hi)/2;
                int cut2= (n1+n2+1)/2-cut1;

                int l1= cut1==0 ? Integer.MIN_VALUE:nums1[cut1-1];
                int l2= cut2==0 ? Integer.MIN_VALUE:nums2[cut2-1];
                int r1= cut1==n1 ? Integer.MAX_VALUE:nums1[cut1];
                int r2= cut2==n2 ? Integer.MAX_VALUE:nums2[cut2];

                if(l1 <= r2 && l2 <= r1){
                    if((n1+n2)%2==0)
                        return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                    else return Math.max(l1,l2);
                }else if(l1>r2){
                    hi=cut1-1;
                }
                else lo=cut1+1;
            }
            return 0.0;
        }
    }

// 双指针combine
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;
            int k = 0;
            double ans = 0;

            int[] comb = new int[nums1.length + nums2.length];

            while(i<nums1.length && j<nums2.length){
                if(nums1[i] <= nums2[j]) {
                    comb[k++] = nums1[i++];
                }
                else if (nums2[j] <= nums1[i]) {
                    comb[k++] = nums2[j++];
                }
            }
//         防止一个短，有元素没进comb去
            while(i< nums1.length)
                comb[k++] = nums1[i++];
            while(j< nums2.length)
                comb[k++] = nums2[j++];

            if(comb.length%2 == 0) {
                int mid = comb.length/2;
                ans = (comb[mid] + comb[mid-1]) / 2.0;
            }else {
                ans = comb[comb.length / 2] / 1.0;
            }

            return ans;
        }
    }

}
