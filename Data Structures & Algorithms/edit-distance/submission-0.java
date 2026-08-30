class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(dp, word1, word2, 0, 0);
    }

    private int solve(int[][] dp, String word1, String word2, int i, int j){
        if(j == word2.length()) return word1.length() - i;
        if(i == word1.length()) return word2.length() - j;
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = solve(dp, word1, word2, i + 1, j + 1);

        if(word1.charAt(i) != word2.charAt(j)){
            dp[i][j] = 1 + Math.min(dp[i][j], Math.min(solve(dp, word1, word2, i + 1, j), solve(dp, word1, word2, i, j + 1)));
        }

        return dp[i][j];
    }
}
