package com.techbow.homework.y2021.m09.cma;

public class LC036 {
//    spiral print的类似的解法
class Solution {
    public boolean isValidSudoku(char[][] board) {
//         dfs中只有array(boolean[]/Boolean[]都可以)才能全局传 premitive的值都是局部变量，传不回来

        boolean[] isValid = new boolean[1];
        isValid[0] = true;
        int n = 3;
        int offset = 0;
//         check column
        for(int j = 0; j < 9; j++){
            HashSet<Character> colSet = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(!colSet.add(board[i][j])){
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < 9; i++){
//             check row
            HashSet<Character> rowSet = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!rowSet.add(board[i][j])){
                        return false;
                    }
                }
                if(i % 3 == 0 && j % 3 == 0){
                    HashSet<Character> numSet = new HashSet<>();
                    dfs(board, i, j, offset, n, numSet, isValid);
                }
//                 check box

                if(!isValid[0]){
                    return false;
                }
            }
        }

        return isValid[0];
    }
    //     check individual 3x3 box
    private void dfs(char[][] box, int x, int y, int offset, int n, HashSet<Character> numSet, boolean[] isValid){
        if( n <= 0){
            return;
        }
        if(n == 1){
            if(box[x + offset][y + offset] != '.'){
                if(!numSet.add(box[x + offset][y + offset])){
                    isValid[0] = false;
                };
            }
            System.out.println(isValid[0]);
            return;
        }

        for(int j = 0; j < n - 1; j ++){
            if(box[x + offset][y + offset + j] != '.'){
                if(!numSet.add(box[x + offset][y + offset + j])){
                    isValid[0] = false;
                }
            }
        }

        for(int i = 0; i < n - 1; i ++){
            if(box[x + offset + i][y + offset + n - 1] != '.'){
                if(!numSet.add(box[x + offset + i][y + offset + n - 1])){
                    isValid[0] =  false;
                }
            }
        }

        for(int j = 0; j < n - 1; j ++){
            if(box[x + offset + n - 1][y + offset + n - 1 - j] != '.'){
                if(!numSet.add(box[x + offset + n - 1][y + offset + n - 1 - j])){
                    isValid[0] =  false;
                }
            }
        }

        for(int i = 0; i < n - 1; i ++){
            if(box[x + offset + n - 1 - i][y + offset] != '.'){
                if(!numSet.add(box[x + offset + n - 1 - i][y + offset])){
                    isValid[0] = false;
                }
            }
        }
        dfs(box, x, y, offset + 1, n - 2, numSet, isValid);
    }

}

//遍历一遍的解法
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use an array to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
    }
}
}
