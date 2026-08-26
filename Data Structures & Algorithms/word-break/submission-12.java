class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0, minLength = Integer.MAX_VALUE;
        Map<Integer, List<String>> map = new HashMap<>();

        for(String word : wordDict){
            maxLength = Math.max(maxLength, word.length());
            minLength = Math.min(minLength, word.length());
            map.computeIfAbsent(word.length(), v -> new ArrayList<>()).add(word);
        }

        int window = Math.min(maxLength, s.length()) + 1;

        boolean[] dp = new boolean[window];
        dp[0] = true;

        for(int i = minLength; i <= s.length(); i++){
            int i1 = i % window;
            dp[i1] = false;
            for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
                int start = i - entry.getKey();
                if(start < 0) continue;
                int j1 = start % window;
                if(!dp[j1]) continue;

                for(String word : entry.getValue()){
                    if(s.startsWith(word, start)){
                        dp[i1] = true;
                        break;
                    }
                }
                if(dp[i1]) break;
            }
        }

        return dp[s.length() % window];
    }
}