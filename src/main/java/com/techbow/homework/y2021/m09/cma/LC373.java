package com.techbow.homework.y2021.m09.cma;

public class LC373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ret = new ArrayList<>();
            if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
                return ret;
            }
            int len1 = nums1.length;
            int len2 = nums2.length;

            HashSet<Cell> set = new HashSet<Cell>();
            PriorityQueue<Cell> queue = new PriorityQueue<Cell>((l1, l2) -> {return l1.val - l2.val;});

            Cell c = new Cell(nums1[0] + nums2[0], 0,0);
            queue.offer(c);
            set.add(c);

            while(k-- > 0){
                if(queue.isEmpty()) break;

                Cell cur = queue.poll();
                ret.add(new ArrayList<>(List.of(nums1[cur.i], nums2[cur.j])));
                int i = cur.i;
                int j = cur.j;

                if(i + 1 < len1){
                    Cell c1 = new Cell(nums1[i + 1] + nums2[j], i + 1, j);
                    if(!set.contains(c1)){
                        queue.offer(c1);
                        set.add(c1);
                    }
                }
                if(j + 1 < len2){
                    Cell c2 = new Cell(nums1[i] + nums2[j + 1], i , j + 1);
                    if(!set.contains(c2)){
                        queue.offer(c2);
                        set.add(c2);
                    }
                }
            }
            return ret;
        }
    }


    class Cell{
        int val, i, j;
        public Cell(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode(){
            return this.i * 31 + this.j;
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Cell){
                Cell c = (Cell) o;
                return this.i == c.i && this.j == c.j;
            } else{
                return false;
            }
        }
    }
}
