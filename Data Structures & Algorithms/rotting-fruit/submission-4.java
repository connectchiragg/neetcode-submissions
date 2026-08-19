class Solution {
    record Orange(int row, int col){}
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
                    oranges.add(new Orange(i, j));
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        while(!oranges.isEmpty()){
            int size = oranges.size();

            while(size-- > 0){
                Orange orange = oranges.poll();

                for(int[] dir : DIRS){
                    int i = orange.row() + dir[0], j = orange.col() + dir[1];
                    
                    if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) continue;
                    // no need to insert empty of rotten oranges
                    if(grid[i][j] == 0 || grid[i][j] == 2) continue;


                    // rotting procedure takes place
                    grid[i][j] = 2;
                    freshOranges--;
                    oranges.add(new Orange(i, j));
                }
            }

            if(!oranges.isEmpty()){
                result++;
            }
        }

        return freshOranges == 0 ? result : -1;
    }
}