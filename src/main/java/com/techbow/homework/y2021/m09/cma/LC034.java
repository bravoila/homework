public class LC034 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0) return new int[]{-1,-1};
            int left = leftPos(nums, target);
            int right = rightPos(nums, target);
            return new int[]{left, right};
        }

        private int leftPos(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return (left == nums.length || nums[left] != target) ? -1 : left;
        }

        private int rightPos(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid] <= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return (right < 0 || nums[right] != target) ? -1 : right;
        }
    }

}
