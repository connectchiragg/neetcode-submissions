class Solution {
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int numIslands(char[][] grid) {
        int result = 0;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited.contains(i * grid[0].length + j)){
                    result++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, Set<Integer> visited, int i, int j){
        int idx = i * grid[0].length + j;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0' || visited.contains(idx)) return;

        visited.add(idx);

        for(int[] dir : DIRS){
            dfs(grid, visited, i + dir[0], j + dir[1]);
        }
    }
}
