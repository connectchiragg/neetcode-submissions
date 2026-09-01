class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][]dp = new Boolean[s.length() + 1][p.length() + 1];

        return solve(dp, s, p, 0, 0);
    }

    private boolean solve(Boolean[][] dp, String s, String p, int i, int j){
        if(dp[i][j] != null) return dp[i][j];
        if(i == s.length() && j == p.length()) return dp[i][j] = true;


        if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
            boolean result = solve(dp, s, p, i, j + 2);
            int temp = i;
            while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))){
                i++;
                result |= solve(dp, s, p, i, j + 2);
            }

            return dp[temp][j] = result;
        }
        if(i == s.length() || j == p.length()) return dp[i][j] = false;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            return dp[i][j] = solve(dp, s, p, i + 1, j + 1);
        }

        return dp[i][j] = false;
    }
}
