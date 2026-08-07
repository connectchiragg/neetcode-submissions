class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[60];
        int left = 0;
        int minLen = s.length();
        int matched = 0;
        int l = -1, r = -1; 

        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i) - 'A']++;
        }

        for(int right = 0; right < s.length(); right++){
            if(map[s.charAt(right) - 'A']-- > 0){
                matched++;
            }

            while(left < s.length() && map[s.charAt(left) - 'A'] < 0){
                map[s.charAt(left) - 'A']++;
                left++;
            }

            if(matched == t.length() && (right - left + 1) <= minLen){
                minLen = right - left + 1;
                l = left;
                r = right;
            }
        }

        return l == -1 ? "" : s.substring(l, r + 1);
    }
}