class Solution {
    record Edge(int i, int j, int cost){}
    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int swimInWater(int[][] grid) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost(), e2.cost()));

        pq.add(new Edge(0, 0, grid[0][0]));
        return dijkstra(pq, grid);
    }

    private int dijkstra(PriorityQueue<Edge> pq, int[][] grid){
        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.i() == grid.length - 1 && curr.j() == grid.length - 1) return curr.cost();

            for(int[] dir : DIRS){
                int i = curr.i() + dir[0], j = curr.j() + dir[1];

                if(i < 0 || j < 0 || i == grid.length || j == grid.length) continue;
                if(grid[i][j] == -1) continue;
                pq.add(new Edge(i, j, Math.max(curr.cost(), grid[i][j])));
                grid[i][j] = -1;
            }
        }

        return -1;
    }
}
