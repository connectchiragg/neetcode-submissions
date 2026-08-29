class Solution {
    record Node(int i, int j, int dist){}

    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        Queue<Node> q = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(dp[i][j] > 0) continue;
                dp[i][j] = 1;
                q.add(new Node(i, j, 1));

                while(!q.isEmpty()){
                    Node curr = q.poll();
                    result = Math.max(result, dp[curr.i()][curr.j()]);
                    for(int[] dir : DIRS){
                        int i1 = curr.i() + dir[0], j1 = curr.j() + dir[1];
                        if(i1 < 0 || j1 < 0 || i1 == matrix.length || j1 == matrix[0].length) continue;
                        if(matrix[i1][j1] <= matrix[curr.i()][curr.j()]) continue;
                        if(curr.dist() + 1 <= dp[i1][j1]) continue;
                        dp[i1][j1] = curr.dist() + 1;
                        q.add(new Node(i1, j1, curr.dist() + 1));
                    }
                }
            }
        }

        return result;
    }
}
