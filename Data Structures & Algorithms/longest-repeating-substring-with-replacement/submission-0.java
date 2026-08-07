class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0;
        int maxFreq = 0;
        int result = 0;
        
        for(int j = 0; j < s.length(); j++){
            maxFreq = Math.max(maxFreq, ++map[s.charAt(j) - 'A']);

            if((j - i + 1) - maxFreq > k){
                map[s.charAt(i) - 'A']--;
                i++;
            }

        }

        return s.length() - i;
    }
}
