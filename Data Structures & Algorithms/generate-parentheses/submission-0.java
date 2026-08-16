class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(result, sb, n, n);
        return result;
    }

    private void solve(List<String> result, StringBuilder sb, int lc, int rc){
        if(lc == 0 && rc == 0){
            result.add(sb.toString());
        }

        if(lc < rc){
            sb.append(')');
            solve(result, sb, lc, rc - 1);
            sb.setLength(sb.length() - 1);
        }

        if(lc > 0){
            sb.append('(');
            solve(result, sb, lc - 1, rc);
            sb.setLength(sb.length() - 1);
        }
    }
}
