package com.techbow.homework.y2021.m09.cma;

public class LC253 {
// MinHeap
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
// min heap where the key for the min heap would be the ending time of meeting
// every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.
            if (intervals.length == 0) {
                return 0;
            }

            Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
            Arrays.sort(intervals, (n1,n2) -> n1[0] - n2[0]);
            // Add the first meeting end time
            pq.add(intervals[0][1]);

            for(int i = 1; i < intervals.length; i ++){
//             start >= end time
                if(intervals[i][0] >= pq.peek()){
                    pq.poll();
                }
//             add new end time
                pq.add(intervals[i][1]);
            }
            return pq.size();
        }
    }

//

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            // Get starts and ends separately
            int len = intervals.length;
            int[] starts = new int[len];
            int[] ends = new int[len];
            for (int i = 0; i < len; i++) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
            }

            // Sort starts and ends array
            Arrays.sort(starts);
            Arrays.sort(ends);

            // Find min needed rooms
            int rooms = 0;
            for (int startIndex = 0, endIndex = 0; startIndex < len; startIndex++) {
                if (starts[startIndex] < ends[endIndex]) {
                    // Start is smaller than end, add one room
                    rooms++;
                } else {
                    // Otherwise, move endIndex
                    endIndex++;
                }
            }

            return rooms;
        }
    }

// 改写comparator
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null){
            return 0;
        }
        List<EndPoint> list = new ArrayList<EndPoint>();
        for(int[] i : intervals){
            list.add(new EndPoint(i[0], false));
            list.add(new EndPoint(i[1], true));
        }

        Collections.sort(list);

        int count = 0;
        int max = 0;
        for(EndPoint ep: list){
            if(!ep.isEnd){
                count++;
            } else{
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}

    class EndPoint implements Comparable<EndPoint>{
        public int val;
        public boolean isEnd;

        public EndPoint(int val, boolean isEnd){
            this.val = val;
            this.isEnd = isEnd;
        }

        public int compareTo(EndPoint ep){
            if(this.val < ep.val){
                return -1;
            }  else if(this.val > ep.val){
                return 1;
            } else{
                if(this.isEnd){
                    return -1;
                } else{
                    return 1;
                }
            }
        }
    }
}
