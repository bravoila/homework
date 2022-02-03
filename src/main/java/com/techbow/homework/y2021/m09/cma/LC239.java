package com.techbow.homework.y2021.m09.cma;

public class LC239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null) return null;
            if(nums.length == 0)return new int[0];
            int[] res = new int[nums.length - k +1];

            Deque<Integer> queue = new LinkedList<Integer>();
            for(int i = 0; i < k; i++){
                update(queue, nums[i]);
            }
            res[0] = queue.peekFirst();
            for(int i = k; i < nums.length; i++){

                if(queue.peekFirst() == nums[i-k]){
                    queue.pollFirst();
                }
                update(queue, nums[i]);
                res[i-k+1] = queue.peek();
            }
            return res;
        }

        private void update(Deque<Integer> queue, int val){
            while(!queue.isEmpty() && val > queue.peekLast()){
                queue.pollLast();
            }
            queue.offerLast(val);
        }
    }

//    LC 答案
    class Solution {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                                             deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }
}
