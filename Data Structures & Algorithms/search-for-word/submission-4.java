class Solution {
    private static final int[][] dirs =  {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && solve(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '-'){
            return false;
        }

        if(board[i][j] != word.charAt(idx)){
            return false;
        }

        char c = board[i][j];
        board[i][j] = '-';
        
        for(int[] dir : dirs){
            if(solve(board, word, idx + 1, i + dir[0], j + dir[1])){
                board[i][j] = c;
                return true;
            }
        }
        board[i][j] = c;
        return false;

    }
}
