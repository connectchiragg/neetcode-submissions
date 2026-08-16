class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void solve(List<List<Integer>> result, int[] nums, List<Integer> curr, int idx){
        if(idx == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        solve(result, nums, curr, idx + 1);
        curr.remove(curr.size() - 1);
        solve(result, nums, curr, idx + 1);
    }
}
