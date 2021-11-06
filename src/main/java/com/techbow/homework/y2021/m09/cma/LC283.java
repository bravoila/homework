public class LC283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums == null || nums.length == 0) return;

            int cur = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    int tmp = nums[cur];
                    nums[cur] = nums[i];
                    nums[i] = tmp;
                    cur++;
                }
            }
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }

            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }

        }
    }
}
