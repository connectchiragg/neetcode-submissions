class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, nums, 0);
        return result;
    }

    private void solve(List<List<Integer>> result, int[] nums, int idx){
        if(idx == nums.length){
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, i, idx);
            solve(result, nums, idx + 1);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
