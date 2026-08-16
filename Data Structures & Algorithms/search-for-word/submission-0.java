class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    result |= solve(board, word, 0, i, j);
                }
            }
        }
        return result;
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

        boolean result = solve(board, word, idx + 1, i - 1, j) || solve(board, word, idx + 1, i + 1, j) ||
                solve(board, word, idx + 1, i, j - 1) || solve(board, word, idx + 1, i, j + 1);

        board[i][j] = c;
        return result;

    }
}
