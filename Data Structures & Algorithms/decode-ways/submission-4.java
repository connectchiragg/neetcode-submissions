class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(dp, s, 0);
    }

    private int decode(int[] dp, String s, int i){
        int result = 0;
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return result;
        if(dp[i] != -1) return dp[i];

        result += decode(dp, s, i + 1);

        if(i < s.length() - 1 && 
        (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))){
            result += decode(dp, s, i + 2);
        }

        return dp[i] = result;
    }
}
