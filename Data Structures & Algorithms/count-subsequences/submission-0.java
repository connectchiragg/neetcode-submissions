class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(dp, s, t, 0, 0);
    }

    private int solve(int[][] dp, String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int result = 0;

        for(int k = i; k < s.length(); k++){
            if(s.charAt(k) == t.charAt(j)){
                result += solve(dp, s, t, k + 1, j + 1);
            }
        }

        return dp[i][j] = result;
    }
}
