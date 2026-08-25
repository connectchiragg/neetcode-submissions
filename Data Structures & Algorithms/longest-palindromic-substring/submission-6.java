class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++){
                if(s.charAt(j) == s.charAt(k)){
                    if(k - j >= right - left){
                        left = j;
                        right = k;
                    }
                } else {
                    break;
                }
            }

            for(int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++){
                if(s.charAt(j) == s.charAt(k)){
                    if(k - j >= right - left){
                        left = j;
                        right = k;
                    }
                } else {
                    break;
                }
            }
        }

        return s.substring(left, right + 1);
    }
}
