class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < j && !isAlphaNumeric(s, i)) i++;
            while(i < j && !isAlphaNumeric(s, j)) j--;

            if(i >= j) break;

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(String s, int i){
        return (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9');
    }
}
