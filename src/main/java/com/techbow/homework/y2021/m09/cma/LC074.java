public class LC074 {
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

