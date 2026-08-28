class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        if(t1.length() < t2.length()){
            String temp = t1;
            t1 = t2;
            t2 = temp;
        }

        if(t2.length() == 0) return 0;

        int[] dp = new int[t2.length()];

        for(int i = 0; i < t1.length(); i++){
            int prev  = 0;
            for(int j = 0; j < t2.length(); j++){
                int temp = dp[j];
                if(t1.charAt(i) == t2.charAt(j)){
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], j > 0 ? dp[j - 1] : 0);
                }
                prev = temp;
            }
        }

        return dp[t2.length() - 1];
    }
}
