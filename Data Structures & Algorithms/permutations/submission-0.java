class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void solve(List<List<Integer>> result, int[] nums, List<Integer> curr, int idx){
        if(idx == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, i, idx);
            curr.add(nums[idx]);
            solve(result, nums, curr, idx + 1);
            swap(nums, i, idx);
            curr.remove(curr.size() - 1);            
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
