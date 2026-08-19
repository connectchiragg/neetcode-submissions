class Solution {
    // a graph is a valid tree, if it is a connected graph without cycles
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] nums = new List[n];

        for(int i = 0; i < n; i++){
            nums[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            nums[edge[0]].add(edge[1]);
            nums[edge[1]].add(edge[0]);
        }

        dfs(nums, 0);

        for(List<Integer> num : nums){
            if(num != null) return false;
        }

        return true;
    }

    private void dfs(List<Integer>[] nums, int i){
        if(nums[i] == null) return;

        List<Integer> list = nums[i];
        nums[i] = null;

        for(int x : list){
            dfs(nums, x);
        }
    }
}







