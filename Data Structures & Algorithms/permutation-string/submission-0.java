class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int left = 0;

        for(int i = 0; i < s1.length(); i++){
            map[s1.charAt(i) - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++){
            int value = s2.charAt(right) - 'a';
            map[value]--;

            while(map[value] < 0){
                map[s2.charAt(left) - 'a']++;
                left++;
            }

            if(right - left + 1 == s1.length()){
                return true;
            }
        }

        return false;
    }
}
