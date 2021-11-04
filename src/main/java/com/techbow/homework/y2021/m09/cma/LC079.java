public class LC079 {
    class Solution {
        public boolean exist(char[][] board, String word) {

            if(board == null || board.length == 0|| board[0] == null|| board[0].length == 0){
                return false;
            }

            int row = board.length;
            int col = board[0].length;

            boolean[][] visited = new boolean[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j ++){
                    if(dfs(board, i,j, word, 0, visited)){
                        return true;
                    }
                }
            }
            return false;

        }

        private boolean dfs(char[][] mat, int i, int j , String word, int idx, boolean[][] visited){
            if(idx == word.length()){
                return true;
            }
            int row = mat.length;
            int col = mat[0].length;
            if (i < 0 || i >= row || j <0 || j >= col|| word.charAt(idx) != mat[i][j] || visited[i][j]){
                return false;
            }

            visited[i][j] = true;
            boolean ret = dfs(mat, i - 1, j , word, idx + 1, visited)
                    || dfs(mat, i + 1, j , word, idx + 1, visited)
                    || dfs(mat, i, j - 1, word, idx + 1, visited)
                    || dfs(mat, i, j + 1, word, idx + 1, visited);
            visited[i][j] = false;
            return ret;
        }

    }
}
