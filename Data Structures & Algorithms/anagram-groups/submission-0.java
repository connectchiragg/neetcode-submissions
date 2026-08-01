class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for(String s : strs){
            List<Integer> chars = new ArrayList<>(Collections.nCopies(26, 0));
            for(int i = 0; i < s.length(); i++){
                int idx = s.charAt(i) - 'a';
                chars.set(idx, chars.get(idx) + 1);
            }

            List<String> curr = map.getOrDefault(chars, new ArrayList<>());

            curr.add(s);
            map.put(chars, curr);
        }

        return new ArrayList<>(map.values());
    }
}
