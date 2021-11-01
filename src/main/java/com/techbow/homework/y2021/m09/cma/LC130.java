public class LC130 {
    class Solution {
        private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};

        public void solve(char[][] board) {
//         C.C
            if(board == null || board[0] == null || board.length == 0|| board[0].length == 0){
                return;
            }

//         从边上的一圈O往里搜,能连上的都还保持O,连不上的其他O则是被X包围的，最后都变成X即可
            int row = board.length, col = board[0].length;
            Queue<int[]> myqueue = new LinkedList<>();


            for(int i = 0; i < row; i++){
                if(board[i][0] == 'O'){
                    board[i][0] = 'Y';
                    int[] temp = {i,0};
                    myqueue.add(temp);
                }

                if(board[i][col - 1] == 'O'){
                    board[i][col - 1] = 'Y';
                    int[] temp = {i,col - 1};
                    myqueue.add(temp);
                }

            }


            for(int j = 0; j < col; j++){
                if(board[0][j] == 'O'){
                    board[0][j] = 'Y';
                    int[] temp = {0,j};
                    myqueue.add(temp);
                }

                if(board[row - 1][j] == 'O'){
                    board[row - 1][j] = 'Y';
                    int[] temp = {row - 1,j};
                    myqueue.add(temp);
                }
            }


            while(!myqueue.isEmpty()){
                int[] curr = myqueue.poll();
                int i = curr[0], j = curr[1];

                for(int[] dir: DIRECTIONS){
                    int ii = i + dir[0], jj = j + dir[1];
                    if(ii >= 0 && ii < row && jj >= 0 && jj < col && board[ii][jj] == 'O'){
                        board[ii][jj] = 'Y';
                        int[] temp = {ii, jj};
                        myqueue.add(temp);
                    }
                }

            }


            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j ++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    } else if(board[i][j] == 'Y'){
                        board[i][j] = 'O';
                    }
                }
            }
            return;

        }
    }
}
