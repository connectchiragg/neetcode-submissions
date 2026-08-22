class Solution {
    record Edge(int i, int j, int cost){}
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost(), e2.cost()));
        int[][] cost = new int[n][n];

        for(int[] row : cost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new Edge(0, 0, grid[0][0]));

        dfs(pq, grid, cost);

        return cost[n - 1][n - 1];
    }

    private void dfs(PriorityQueue<Edge> pq, int[][] grid, int[][] cost){
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            cost[curr.i()][curr.j()] = curr.cost();

            if(curr.i() == grid.length - 1 && curr.j() == grid.length - 1) return;

            for(int[] dir : DIRS){
                int i = curr.i() + dir[0], j = curr.j() + dir[1];

                if(i < 0 || j < 0 || i == grid.length || j == grid.length) continue;
                
                int currCost = Math.max(curr.cost(), grid[i][j]);

                if(currCost >= cost[i][j]) continue;

                pq.add(new Edge(i, j, currCost));
            }
        }
    }
}
