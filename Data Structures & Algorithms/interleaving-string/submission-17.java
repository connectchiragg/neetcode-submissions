class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 && j == 0) continue;
                boolean temp = dp[j];
                dp[j] = false;
                if(i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[j] |= temp;
                }

                if(j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[j] |= dp[j - 1];
                }
            }
        }

        return dp[s2.length()];
    }
}
