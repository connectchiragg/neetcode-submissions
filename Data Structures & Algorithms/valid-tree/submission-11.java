class Solution {
    private static final List<Integer> FLAG = new ArrayList<>();

    // a graph is a valid tree, if it is a connected graph without cycles
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] nums = new List[n];

        for(int[] edge : edges){
            if(nums[edge[0]] == null) nums[edge[0]] = new ArrayList<>();
            if(nums[edge[1]] == null) nums[edge[1]] = new ArrayList<>();
            nums[edge[0]].add(edge[1]);
            nums[edge[1]].add(edge[0]);
        }

        if(!dfs(nums, 0, 0)) return false;

        for(int i = 1; i < n; i++){
            if(nums[i] != FLAG || !dfs(nums, i, i)) return false;
        }

        return true;
    }

    private boolean dfs(List<Integer>[] nums, int i, int parent){
        if(nums[i] == FLAG || nums[i] == null) return true;
        if(nums[i].isEmpty()) return false;

        List<Integer> list = nums[i];
        nums[i] = new ArrayList<>();

        for(int x : list){
            if(x == parent) continue;
            if(!dfs(nums, x, i)){
                return false;
            }
        }

        nums[i] = FLAG;
        return true;
    }
}







