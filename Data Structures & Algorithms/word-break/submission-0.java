class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();

        for(String word : wordDict){
            if(word.length() <= s.length()){
                set.add(word);
            }
        }

        dp[0] = true;

        for(int i = 1; i < s.length() + 1; i++){
            for(String word : wordDict){
                if(i < word.length()) continue;
                int prev = i - word.length();
                dp[i] |= set.contains(s.substring(prev, i)) && dp[prev];
            }
        }

        return dp[s.length()];
    }
}