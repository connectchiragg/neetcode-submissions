class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() < word2.length()){
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int[] dp = new int[word2.length() + 1];

        for (int i = 1; i <= word2.length(); i++) {
            dp[i] = i;
        }

        for(int i = 1; i <= word1.length(); i++){
            int prev = dp[0];
            dp[0] = i;
            for(int j = 1; j <= word2.length(); j++){
                int curr = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[j] = prev; // prev row, prev value
                } else {
                    // prev row, prev value | prev row, this value | this row | prev value
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }
                prev = curr;
            }
        }

        return dp[word2.length()];
    }
}
