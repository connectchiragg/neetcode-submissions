class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, nums, target, new ArrayList<>(), 0);
        return result;
    }

    private void solve(
        List<List<Integer>> result, 
        int[] nums, 
        int target, 
        List<Integer> curr, 
        int idx){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(idx == nums.length || target < 0){
            return;
        }

        curr.add(nums[idx]);
        solve(result, nums, target - nums[idx], curr, idx);
        curr.remove(curr.size() - 1);
        solve(result, nums, target, curr, idx + 1);
    }
}
