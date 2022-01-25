package com.techbow.homework.y2021.m09.cma;

public class LC941 {
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if(arr.length < 3){
                return false;
            }

//         climb
            int i = 0;
            int arrLen = arr.length;
            while(i < arrLen - 1 && arr[i] < arr[i + 1]){
                i ++;
            }
//         单边上行或者单边下行
            if(i == 0 || i == arrLen - 1){
                return false;
            }

//         go down
            while( i < arrLen - 1 && arr[i] > arr[i + 1]){
                i++;
            }

            return i == arrLen - 1;
        }
    }
}
