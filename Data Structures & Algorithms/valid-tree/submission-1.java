class Solution {
    // a graph is a valid tree, if it is a connected graph without cycles
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] nums = new List[n];

        for(int[] edge : edges){
            if(nums[edge[0]] == null){
                nums[edge[0]] = new ArrayList<>();
            }

            if(nums[edge[1]] == null){
                nums[edge[1]] = new ArrayList<>();
            }
            nums[edge[0]].add(edge[1]);
            nums[edge[1]].add(edge[0]);
        }

        dfs(nums, 0);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != null) System.out.println(i + "->" + nums[i]);
        }

        for(List<Integer> num : nums){
            if(num != null) return false;
        }

        return true;
    }

    private void dfs(List<Integer>[] nums, int i){
        if(nums[i] == null) return;
        if(nums[i].isEmpty()) return;

        List<Integer> list = nums[i];
        nums[i] = new ArrayList<>();

        for(int x : list){
            dfs(nums, x);
        }

        nums[i] = null;
    }
}







