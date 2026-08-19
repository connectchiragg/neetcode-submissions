class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        List<Integer>[] nums = new List[n];

        for(int i = 0; i < n; i++){
            nums[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            nums[edge[0]].add(edge[1]);
            nums[edge[1]].add(edge[0]);
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != null){
                result++;
                dfs(nums, i);
            }
        }

        return result;
    }

    private void dfs(List<Integer>[] nums, int i){
        if(nums[i] == null) return;

        List<Integer> list = nums[i];
        nums[i] = null;

        for(int x : list) dfs(nums, x);
    }
}
