class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0, minLength = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < wordDict.size(); i++){
            String word = wordDict.get(i);
            maxLength = Math.max(maxLength, word.length());
            minLength = Math.min(minLength, word.length());
            map.computeIfAbsent(word.length(), v -> new ArrayList<>()).add(i);
        }

        int window = Math.min(maxLength, s.length()) + 1;

        boolean[] dp = new boolean[window];
        dp[0] = true;

        for(int i = minLength; i <= s.length(); i++){
            int i1 = i % window;
            dp[i1] = false;
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                int start = i - entry.getKey();
                if(start < 0) continue;
                int j1 = start % window;
                if(!dp[j1]) continue;

                for(int k : entry.getValue()){
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