class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, nums, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void solve(
        List<List<Integer>> result, 
        int[] nums, 
        int target, 
        List<Integer> curr, 
        int idx, 
        int sum){
        if(sum == target){
            List<Integer> combo = new ArrayList<>(curr);
            result.add(combo);
            return;
        }

        if(idx == nums.length || sum > target){
            return;
        }

        int duplicates = 0;

        while(sum <= target){
            solve(result, nums, target, curr, idx + 1, sum);
            curr.add(nums[idx]);
            duplicates++;
            sum += nums[idx];
        }

        while(duplicates-- > 0){
            curr.remove(curr.size() - 1);
        }

    }
}
