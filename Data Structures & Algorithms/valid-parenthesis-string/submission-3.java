class Solution {
    public boolean checkValidString(String s) {
        int open = 0, closed = 0, wild = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            } else if(s.charAt(i) == ')'){
                closed++;
            } else {
                wild++;
            }

            if(open + wild < closed) return false;
        }

        open = 0;
        closed = 0;
        wild = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')'){
                open++;
            } else if(s.charAt(i) == '('){
                closed++;
            } else {
                wild++;
            }

            if(open + wild < closed) return false;
        }

        return true;
    }
}
