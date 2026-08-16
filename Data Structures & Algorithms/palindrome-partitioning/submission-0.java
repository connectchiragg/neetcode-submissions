class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(result, s, new ArrayList<>(), 0, 0);
        return result;
    }

    private void solve(List<List<String>> result, String s, List<String> curr, int start, int end){
        if(end == s.length()){
            if(start == s.length()){
                // this means that a palindrome just got added before this turn,
                // so all elements are included in curr
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        if(isPalindrome(s, start, end)){
            curr.add(s.substring(start, end + 1));
            solve(result, s, curr, end + 1, end + 1);
            curr.remove(curr.size() - 1);
        }

        solve(result, s, curr, start, end + 1);        
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
