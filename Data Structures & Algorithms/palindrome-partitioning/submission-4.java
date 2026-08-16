class Solution {
    private boolean[][] palindromes;

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        palindromes = new boolean[s.length()][s.length()];
        
        computePalindromes(s);
        solve(result, s, new ArrayList<>(), 0, 0);
        return result;
    }

    private void solve(
        List<List<String>> result,
        String s,
        List<String> curr,
        int start,
        int end){
        if(end == s.length()){
            if(start == s.length()){
                // this means that a palindrome just got added before this turn,
                // so all elements are included in curr
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        if(palindromes[start][end]){
            curr.add(s.substring(start, end + 1));
            solve(result, s, curr, end + 1, end + 1);
            curr.remove(curr.size() - 1);
        }

        solve(result, s, curr, start, end + 1);        
    }

    private void computePalindromes(String s){
        int n = s.length();

        for(int len = 1; len <= n; len++){
            for(int start = 0; start <= n - len; start++){
                int i = start, j = start + len - 1;
                palindromes[i][j] =  (s.charAt(i) == s.charAt(j)) && (len <= 2 || palindromes[i + 1][j - 1]);
            }
        }
    }
}
