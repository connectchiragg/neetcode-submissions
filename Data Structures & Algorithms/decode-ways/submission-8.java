class Solution {
    public int numDecodings(String s) {
        int first = 1, second = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int curr = 0;
            if(s.charAt(i) != '0'){
                curr = first;

                if(
                    i < s.length() - 1 && 
                    (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
                ){
                    curr += second;
                }
            }

            second = first;
            first = curr;
        }

        return first;
    }
}
