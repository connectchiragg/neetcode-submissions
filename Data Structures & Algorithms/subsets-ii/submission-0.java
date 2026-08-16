class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void solve(List<List<Integer>> result, int[] nums, List<Integer> curr, int idx){
        if(idx == nums.length){
            List<Integer> subset = new ArrayList<>(curr);
            result.add(subset);
            return;
        }

        curr.add(nums[idx]);
        solve(result, nums, curr, idx + 1);
        curr.remove(curr.size() - 1);

        while(idx + 1 < nums.length && nums[idx + 1] == nums[idx]){
            idx++;
        }

        solve(result, nums, curr, idx + 1);
    }
}
