class Solution {
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int numIslands(char[][] grid) {
        int result = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, result, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int result, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        for(int[] dir : DIRS){
            dfs(grid, result, i + dir[0], j + dir[1]);
        }
    }
}
