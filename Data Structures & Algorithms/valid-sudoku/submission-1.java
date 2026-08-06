class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] r = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] b = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int v = board[i][j] - '1';
                int box = getBox(i, j);

                if(r[i][v] || c[j][v] || b[box][v]){
                    // invalid
                    return false;
                }

                r[i][v] = true;
                c[j][v] = true;
                b[box][v] = true;
            }
        }

        return true;
    }

    private int getBox(int r, int c){
        // 4, 4 -> 4; 7, 0 -> 7
        return ((c/ 3) * 3) + (r / 3);
    }
}
