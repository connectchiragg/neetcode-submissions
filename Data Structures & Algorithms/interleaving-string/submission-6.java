class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result = false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        if(s3.length() != s1.length() + s2.length()) return false;
        return solve(s1, s2, s3, 0, 0, dp);
    }

    private boolean solve(String a, String b, String c, int ai, int bi, Boolean[][] dp){
        if(ai + bi == c.length()) return true;

        if(dp[ai][bi] != null) return dp[ai][bi];

        boolean result = false;
        int temp = ai;

        if(ai < a.length() && c.charAt(ai + bi) == a.charAt(ai)){
            while(ai < a.length() && c.charAt(ai + bi) == a.charAt(ai)){
                ai++;
                result |= solve(a, b, c, ai, bi, dp);
            }
        }

        ai = temp;
        int temp2 = bi;

        if(bi < b.length() && c.charAt(ai + bi) == b.charAt(bi)){
            while(bi < b.length() && c.charAt(ai + bi) == b.charAt(bi)){
                bi++;
                result |= solve(a, b, c, ai, bi, dp);
            }
        }

        bi = temp2;

        return dp[ai][bi] = result;
    }
}
