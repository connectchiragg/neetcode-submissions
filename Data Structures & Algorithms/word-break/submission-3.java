class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i < s.length() + 1; i++){
            for(String word : wordDict){
                if(i < word.length()) continue;
                int prev = i - word.length();
                dp[i] |= word.equals(s.substring(prev, i)) && dp[prev];
            }
        }

        return dp[s.length()];
    }
}