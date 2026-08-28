class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;

        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        boolean[] dp = new boolean[s2.length() + 1];

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                dp[j] = (i == 0 && j == 0) || 
                        i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j] ||
                        j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1];

            }
        }

        return dp[s2.length()];
    }
}
