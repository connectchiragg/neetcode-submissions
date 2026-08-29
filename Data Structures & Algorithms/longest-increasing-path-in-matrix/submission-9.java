class Solution {
    record Node(int i, int j){}

    private static final int[][] DIRS = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int[][] indegree = new int[matrix.length][matrix[0].length];
        Queue<Node> q = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                for(int[] dir : DIRS){
                    int i1 = i + dir[0], j1 = j + dir[1];
                    if(i1 < 0 || j1 < 0 || i1 == matrix.length || j1 == matrix[0].length) continue;
                    if(matrix[i1][j1] < matrix[i][j]) indegree[i][j]++;
                }

                if(indegree[i][j] == 0) q.add(new Node(i, j));
            }
        }

        while(!q.isEmpty()){
            result++;
            int size = q.size();

            while(size-- > 0){
                Node curr = q.poll();

                for(int[] dir : DIRS){
                    int i1 = curr.i() + dir[0], j1 = curr.j() + dir[1];
                    if(i1 < 0 || j1 < 0 || i1 == matrix.length || j1 == matrix[0].length) continue;

                    if(matrix[i1][j1] > matrix[curr.i()][curr.j()]) {
                        indegree[i1][j1]--;
                        if(indegree[i1][j1] == 0) q.add(new Node(i1, j1));
                    }
                }
            }
        }

        return result;
    }
}
