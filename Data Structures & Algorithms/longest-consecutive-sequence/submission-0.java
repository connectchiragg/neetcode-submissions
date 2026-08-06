class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for(int i : nums){
            set.add(i);
        }

        for(int i : set){
            if(set.contains(i - 1)) continue;
            int curr = 0;
            while(set.contains(i)){
                curr += 1;
                result = Math.max(result, curr);
                i++;
            }
        }

        return result;
    }
}
