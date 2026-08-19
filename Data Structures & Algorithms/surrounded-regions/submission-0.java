class Solution {
    private final static int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for(int j = 0; j < board[0].length; j++){
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'o'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(board[i][j] != 'O') return;


        // mark this cell as 'o', representing ducking behavior from final blast
        board[i][j] = 'o';

        for(int[] dir : DIRS){
            int i1 = i + dir[0], j1 = j + dir[1];

            if(i1 < 0 || j1 < 0 || i1 == board.length || j1 == board[0].length) continue;
            dfs(board, i1, j1);
        }
    }
}
