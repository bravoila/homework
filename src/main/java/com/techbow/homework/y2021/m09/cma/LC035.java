public class LC035 {
//    method 1
    class Solution {
        public int searchInsert(int[] nums, int target) {
//         smallest largest position
            int left = 0;
            int right = nums.length - 1;

            while(left <= right){
                int med = left + (right - left)/2;
                if(nums[med] == target){
                    return med;
                } else if(nums[med] > target){
                    right = med - 1;
                } else{
                    left = med + 1;
                }
            }
            return left;
        }
    }

//    method 3


}
