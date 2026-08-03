class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        int curr = 0;
        Map<Character, Integer> idx = new HashMap<>();

        for(int i = 0; i < n; i++){
            Character c = s.charAt(i);
            if(idx.containsKey(c) && (idx.get(c) >= i - curr)){
                result = Math.max(result, curr);
                curr = i - idx.get(c);
            } else {
                curr++;
            }

            idx.put(c, i);
        }

        return Math.max(result, curr);
    }
}
