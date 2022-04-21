public class LC074 {
    // S1: primitive 2 times binary search (1st largest smaller=) O(logm + logn)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
                return false;
            }

            int row = matrix.length;
            int col = matrix[0].length;

            int left = 0;
            int right = row - 1;
            int med;
            // 在第一列 找比target小的最大的
            while(left <= right){
                med = left + (right - left)/2;
                if(matrix[med][0] == target){
                    return true;
                } else if(matrix[med][0] < target){
                    left = med + 1;
                } else{
                    right = med - 1;
                }
            }

            if(right >=0 && right < row){
                int l = 0;
                int r = col -1;

                while(l <= r){
                    med = l + (r - l)/2;
                    if(matrix[right][med] == target){
                        return true;
                    } else if(matrix[right][med] < target){
                        l = med + 1;
                    } else{
                        r = med - 1;
                    }
                }
            }
            return false;
        }
    }

    // S2:拉直
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
//         C.C
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
                return false;
            }
            int rowLen = matrix.length;
            int colLen = matrix[0].length;

            int left = 0;
            int right = rowLen * colLen - 1;

            while(left <= right){
                int med = left + (right - left)/2;
                int medVal = matrix[med / colLen][med % colLen];
                if(medVal == target){
                    return true;
                }else if(medVal > target){
                    right = med - 1;
                } else{
                    left = med + 1;
                }
            }

            return false;
        }
    }
}

