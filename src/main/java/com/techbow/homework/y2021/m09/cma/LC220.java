package com.techbow.homework.y2021.m09.cma;

public class LC220 {

//    Time limit exceed
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            if(nums.length < 2){
                return false;
            }

            int slow = 0;
            int fast = 0;

            while(fast < nums.length){
                for(int i = slow; i < fast; i ++){
                    if(Math.abs((long) nums[fast] - nums[i]) <= t){
                        return true;
                    }
                }
                fast++;
                if(fast - slow > k){
                    slow++;
                }
            }
            return false;
        }
    }
// Bucket sort
    public class Solution {
        // Get the ID of the bucket from element value x and bucket width w
        // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
        private long getID(long x, long w) {
            return x < 0 ? (x + 1) / w - 1 : x / w;
        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0) return false;
            Map<Long, Long> d = new HashMap<>();
            long w = (long)t + 1;
            for (int i = 0; i < nums.length; i++) {
                long m = getID(nums[i], w);
                // check if bucket m is empty, each bucket may contain at most one element
                if (d.containsKey(m))
                    return true;
                // check the neighbor buckets for almost duplicate
                if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                    return true;
                if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                    return true;
                // now bucket m is empty and no almost duplicate in neighbor buckets
                d.put(m, (long)nums[i]);
                if (i >= k) d.remove(getID(nums[i - k], w));
            }
            return false;
        }
    }

}
