class Solution {
    private static final int[][] DIRS = new int[][]{
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}

    };

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int k = -1, i = 0, j = -1;
        while(true){
            k = ++k % 4;
            boolean available = false;

            while(i + DIRS[k][0] >= 0 && i + DIRS[k][0] < matrix.length && j + DIRS[k][1] >= 0 && j + DIRS[k][1] < matrix[0].length && matrix[i + DIRS[k][0]][j + DIRS[k][1]] != Integer.MAX_VALUE){
                available = true;
                i += DIRS[k][0];
                j += DIRS[k][1];

                result.add(matrix[i][j]);
                matrix[i][j] = Integer.MAX_VALUE;
            }

            if(!available) return result;
        }
    }
}
