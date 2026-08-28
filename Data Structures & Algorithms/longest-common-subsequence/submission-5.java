class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int a = t1.length(), b = t2.length();
        int[][] dp = new int[a][b];

        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(t1.charAt(i) == t2.charAt(j)){
                    dp[i][j] = 1 + ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }

        return dp[a - 1][b - 1];
    }
}
