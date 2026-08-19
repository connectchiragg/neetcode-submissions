class Solution {
    record Orange(int row, int col, int expiry){}
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        int result = 0;
        int freshOranges = 0;
        Queue<Orange> oranges = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    // adding 0 expiry for rotten ones because 0 minutes needed to expire
                    oranges.add(new Orange(i, j, 0));
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        while(!oranges.isEmpty()){
            Orange orange = oranges.poll();

            for(int[] dir : DIRS){
                int i = orange.row() + dir[0], j = orange.col() + dir[1];
                
                if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) continue;
                if(grid[i][j] == 0 || grid[i][j] == 2) continue;


                // rotting procedure takes place
                grid[i][j] = 2;
                freshOranges--;
                result = Math.max(result, orange.expiry() + 1);
                oranges.add(new Orange(i, j, orange.expiry() + 1));
            }
        }

        return freshOranges == 0 ? result : -1;
    }
}
