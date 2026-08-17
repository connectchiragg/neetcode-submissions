class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        List<StringBuilder> sol = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sol.add(new StringBuilder(".".repeat(n)));
        }

        solve(result, sol, 0, col, d1, d2, n);
        return result;
    }

    private void solve(
        List<List<String>> result,
        List<StringBuilder> sol,
        int r,
        boolean[] col,
        boolean[] d1,
        boolean[] d2,
        int n
    ){
        if(r == n){
            // end of rows reached
            result.add(sol.stream().map(sb -> sb.toString()).toList());
            return;
        }

        StringBuilder row = sol.get(r);

        for(int c = 0; c < n; c++){
            if(!col[c] && !d1[r - c + n - 1] && !d2[r + c]){
                addQueen(row, col, d1, d2, r, c, n);
                solve(result, sol, r + 1, col, d1, d2, n);
                removeQueen(row, col, d1, d2, r, c, n);
            }
        }
    }

    private void addQueen(
        StringBuilder row,
        boolean[] col, 
        boolean[] d1, 
        boolean[] d2, 
        int r,
        int c,
        int n
    ){
        row.setCharAt(c, 'Q');
        col[c] = true;
        d1[r - c + n - 1] = true;
        d2[r + c] = true;
    }

    private void removeQueen(
        StringBuilder row,
        boolean[] col, 
        boolean[] d1, 
        boolean[] d2, 
        int r,
        int c,
        int n
    ){
        row.setCharAt(c, '.');
        col[c] = false;
        d1[r - c + n - 1] = false;
        d2[r + c] = false;
    }
}
