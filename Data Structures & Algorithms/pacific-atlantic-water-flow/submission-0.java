class Solution {
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        boolean[][] pac = new boolean[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++){
            dfs(result, heights, i, 0, atl, pac, true);
            dfs(result, heights, i, heights[0].length - 1, atl, pac, false);
        }

        for(int j = 0; j < heights[0].length; j++){
            dfs(result, heights, 0, j, atl, pac, true);
            dfs(result, heights, heights.length - 1, j, atl, pac, false);
        }

        return result;
    }

    private void dfs(
        List<List<Integer>> result,
        int[][] heights, int i, int j,
        boolean[][] atl,
        boolean[][] pac,
        boolean isAtlantic
    ){
        if(atl[i][j] && isAtlantic) return;
        if(pac[i][j] && !isAtlantic) return;

        if(isAtlantic){
            atl[i][j] = true;
        } else {
            pac[i][j] = true;
        }

        if(atl[i][j] && pac[i][j]){
            result.add(List.of(i, j));
        }

        for(int[] dir : DIRS){
            int i1 = i + dir[0], j1 = j + dir[1];

            if(i1 < 0 || j1 < 0 || i1 == heights.length || j1 == heights[0].length) continue;
            if(heights[i][j]  > heights[i1][j1]) continue;
            dfs(result, heights, i1, j1, atl, pac, isAtlantic);
        }
    }
}
