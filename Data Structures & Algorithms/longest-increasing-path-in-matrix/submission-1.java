class Solution {
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, solve(dp, matrix, i, j));
            }
        }

        return result;
    }

    private int solve(int[][] dp, int[][] matrix, int i, int j){
        if(dp[i][j] == -2) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int result = 0;
        dp[i][j] = -2;

        for(int[] dir : DIRS){
            int i1 = i + dir[0], j1 = j + dir[1];
            if(i1 < 0 || j1 < 0 || i1 == matrix.length || j1 == matrix[0].length) continue;
            if(matrix[i1][j1] <= matrix[i][j]) continue;
            result = Math.max(result, solve(dp, matrix, i1, j1));
        }

        return dp[i][j] = ++result;
    }
}
