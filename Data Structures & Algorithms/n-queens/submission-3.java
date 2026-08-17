class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(result, board, 0, col, d1, d2);
        return result;
    }

    private void solve(
        List<List<String>> result,
        char[][] board,
        int r,
        boolean[] col,
        boolean[] d1,
        boolean[] d2
    ){
        int n = board.length;

        if(r == n){
            // end of rows reached
            List<String> solution = new ArrayList<>();
            for (char[] row : board) {
                solution.add(new String(row));
            }

            result.add(solution);
            return;
        }

        char[] row = board[r];

        for(int c = 0; c < n; c++){
            if(!col[c] && !d1[r - c + n - 1] && !d2[r + c]){
                addQueen(row, col, d1, d2, r, c, n);
                solve(result, board, r + 1, col, d1, d2);
                removeQueen(row, col, d1, d2, r, c, n);
            }
        }
    }

    private void addQueen(
        char[] row,
        boolean[] col, 
        boolean[] d1, 
        boolean[] d2, 
        int r,
        int c,
        int n
    ){
        row[c] = 'Q';
        col[c] = true;
        d1[r - c + n - 1] = true;
        d2[r + c] = true;
    }

    private void removeQueen(
        char[] row,
        boolean[] col, 
        boolean[] d1, 
        boolean[] d2, 
        int r,
        int c,
        int n
    ){
        row[c] = '.';
        col[c] = false;
        d1[r - c + n - 1] = false;
        d2[r + c] = false;
    }
}
