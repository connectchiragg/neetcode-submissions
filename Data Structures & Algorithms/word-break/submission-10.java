class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int window = 0;

        for(String word : wordDict){
            window = Math.max(window, word.length());
        }

        List<Integer>[] map = new List[window + 1];

        for(int i = 0; i < wordDict.size(); i++){
            String word = wordDict.get(i);

            if(map[word.length()] == null){
                map[word.length()] = new ArrayList<>();
            }

            map[word.length()].add(i);
        }

        window = Math.min(window, s.length());
        window++;

        boolean[] dp = new boolean[window];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            int i1 = i % window;
            dp[i1] = false;
            for(int j = 0; j < Math.min(map.length, i + 1); j++){
                int start = i - j;
                int j1 = start % window;
                if(!dp[j1] || map[j] == null) continue;

                for(int k : map[j]){
                    String word = wordDict.get(k);
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