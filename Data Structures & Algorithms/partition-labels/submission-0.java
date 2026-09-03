class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] ends = new int[26];
        int end = 0, size = 0;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            ends[idx] = Math.max(ends[idx], i);
        }

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            end = Math.max(end, ends[idx]);
            size++;

            if(i == end){
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}
