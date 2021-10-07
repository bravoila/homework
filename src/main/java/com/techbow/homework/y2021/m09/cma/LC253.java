package com.techbow.homework.y2021.m09.cma;

public class LC253 {
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
}
