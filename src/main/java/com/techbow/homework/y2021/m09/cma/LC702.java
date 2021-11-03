public class LC702 {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     public int get(int index) {}
     * }
     */

    class Solution {
        //     Actually, int cannot be null, just for demo for edge cases.
        public int search(ArrayReader reader, int target) {
//         TODO: long search()
//         C.C
            int start = 0;
            int end = 1;
            while(Integer.valueOf(reader.get(end)) != null && reader.get(end) < target){
                start = end;
                end *= 2;
            }

            while(start <= end){
                int med = start + (end - start)/2;
                if(Integer.valueOf(reader.get(med)) != null && reader.get(med) == target){
                    return med;
                } else if(Integer.valueOf(reader.get(med)) == null || reader.get(med) > target){
                    end = med - 1;
                } else{
                    start = med + 1;
//     else if (myArray.get(mid) != null && myArray.get(mid) < t) start = mid + 1;
                }
            }
            return -1;

        }
    }
}
