public class LC034 {
    // option 1 logn + logn = 2logn = O(logn)
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
// option 2 logn + n = O(n)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // cc
            if(nums == null || nums.length == 0){
                return new int[]{-1, - 1};
            }

            int left = binarySearch(nums, target);
            // 如果left越界了或者left不等于target，那么就是没找到
            if(left > nums.length - 1 || nums[left] != target){
                return new int[]{-1, - 1};
            }

            int i;
            for(i = left; i < nums.length; i++){
                if(nums[i] != target){
                    break;
                }
            }
            return new int[]{left, i - 1};

        }
        //     find leftmost element
        private int binarySearch(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            int med;

            while(left <= right){
                med = left + (right - left)/2;
                if(nums[med] >= target){
                    right = med - 1;
                } else{
                    left = med + 1;
                }
            }
            return left;
        }
    }
}
