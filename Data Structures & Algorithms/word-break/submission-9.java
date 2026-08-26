class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort((w1, w2) -> Integer.compare(w1.length(), w2.length()));
        int window = Math.min(wordDict.get(wordDict.size() - 1).length(), s.length()) + 1;

        boolean[] dp = new boolean[window];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            int i1 = i % window;
            dp[i1] = false;
            for(String word : wordDict){
                if(i < word.length()) break;
                int j = i - word.length();
                int j1 = j % window;
                dp[i1] |= dp[j1] && s.startsWith(word, j);
                if(dp[i1]) break;
            }
        }

        return dp[s.length() % window];
    }
}