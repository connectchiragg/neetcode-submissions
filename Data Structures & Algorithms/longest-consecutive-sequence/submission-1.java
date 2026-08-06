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
                curr++;
                i++;
            }

            result = Math.max(result, curr);
        }

        return result;
    }
}
