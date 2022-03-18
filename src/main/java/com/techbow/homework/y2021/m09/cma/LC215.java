package com.techbow.homework.y2021.m09.cma;

public class LC215 {
    // minheap
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // init heap 'the smallest element first'
            PriorityQueue<Integer> heap =
                    new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

            // keep k largest elements in the heap
            for (int n: nums) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }
            // output
            return heap.poll();
        }
    }
    //quick selection
    class Solution {
        //quick selection
        public int findKthLargest(int[] nums, int k) {
            return search(nums, 0, nums.length - 1, k);
        }

        private int search(int[] nums, int start, int end, int k){
            if(start == end){
                return nums[start];
            }

            int q = partition(nums, start, end);
            int rank = q - start + 1;
            if(rank == k){
                return nums[q];
            } else if(rank < k){
                return search(nums, q + 1, end, k - rank);
            } else{
                return search(nums, start, q - 1, k);
            }
        }

        private int partition(int[] nums, int start, int end){
            int pivotIndex = end;
            int pivot = nums[pivotIndex];

            int i = start - 1;
            for(int j = start; j < end; j++){
                if(nums[j] > pivot){
                    swap(nums, ++i, j);
                }
            }
            swap(nums, ++i, end);
            return i;
        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
