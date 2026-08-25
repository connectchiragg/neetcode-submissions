class Solution {
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        int left = -1, right = -1;

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(dp, s, i, j) && (j - i >= right - left)){
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private boolean isPalindrome(Boolean[][] dp, String s, int left, int right){
        if(left > right) return true;
        if(dp[left][right] != null) return dp[left][right];

        return dp[left][right] = 
        s.charAt(left) == s.charAt(right) && 
        isPalindrome(dp, s, left + 1, right - 1);
    }
}
