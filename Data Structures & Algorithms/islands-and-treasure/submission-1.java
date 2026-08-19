class Solution {
    record Cell(int row, int col) {}

    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void islandsAndTreasure(int[][] grid) {
        Queue<Cell> q = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.add(new Cell(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Cell cell = q.poll();

            for(int[] dir : DIRS){
                int i = cell.row() + dir[0], j = cell.col() + dir[1];
                if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || 
                   grid[i][j] == 0 || grid[i][j] == -1 || grid[i][j] != Integer.MAX_VALUE) continue;
                grid[i][j] = grid[cell.row()][cell.col()] + 1;
                q.add(new Cell(i, j));
            }
        }
    }
}
