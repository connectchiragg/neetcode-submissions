class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int window = 0;

        for(String word : wordDict){
            window = Math.max(window, word.length());
        }

        window = Math.min(window, s.length());
        window++;

        boolean[] dp = new boolean[window];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(String word : wordDict){
                if(i < word.length()) continue;
                int j = i - word.length();
                int i1 = i % window, j1 = j % window;
                dp[i1] = false;
                dp[i1] |= word.equals(s.substring(j, i)) && dp[j1];
                if(dp[i1]) break;
            }
        }

        return dp[s.length() % window];
    }
}