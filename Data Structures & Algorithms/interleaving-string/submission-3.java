class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result = false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        if(s3.length() != s1.length() + s2.length()) return false;
        return solve(s1, s2, s3, 0, 0, 0, 0, 0, dp);
    }

    private boolean solve(String a, String b, String c, int ai, int bi, int ci, int countA, int countB, Boolean[][] dp){
        if(ci == c.length()){
            if(Math.abs(countA - countB) > 1) return false;
            return true; 
        }

        if(dp[ai][bi] != null) return dp[ai][bi];

        boolean result = false;
        int temp = ci;
        int temp2 = ai;

        if(ai < a.length() && c.charAt(ci) == a.charAt(ai)){
            while(ci < c.length() && ai < a.length() && c.charAt(ci) == a.charAt(ai)){
                ci++;
                ai++;
                result |= solve(a, b, c, ai, bi, ci, countA + 1, countB, dp);
            }
        }

        ci = temp;
        ai = temp2;
        int temp3 = bi;

        if(bi < b.length() && c.charAt(ci) == b.charAt(bi)){
            while(ci < c.length() && bi < b.length() && c.charAt(ci) == b.charAt(bi)){
                ci++;
                bi++;
                result |= solve(a, b, c, ai, bi, ci, countA, countB + 1, dp);
            }
        }

        bi = temp3;

        return dp[ai][bi] = result;
    }
}
