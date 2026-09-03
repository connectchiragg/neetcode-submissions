class DSU {
    int[] parent;

    public DSU(int n){
        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(x == parent.length) return x;

        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Integer[] points = new Integer[queries.length];
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            points[i] = i;
        }

        Arrays.fill(result, -1);
        Arrays.sort(points, (p1, p2) -> Integer.compare(queries[p1], queries[p2]));
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1] - i1[0], i2[1] - i2[0]));

        DSU dsu = new DSU(queries.length);

        for(int[] interval : intervals){
            fill(interval, points, queries, result, dsu);
        }

        return result;
    }

    private void fill(int[] interval, Integer[] points, int[] queries, int[] result, DSU dsu){
        int start = -1, end = -1;

        for(int jump = queries.length / 2; jump > 0; jump /= 2){
            while(start + jump < queries.length && queries[points[start + jump]] < interval[0]) start += jump;
        }

        start++;

        for(int jump = queries.length / 2; jump > 0; jump /= 2){
            while(end + jump < queries.length && queries[points[end + jump]] <= interval[1]) end += jump;
        }

        if(end == -1) return;

        int i = dsu.find(start);

        while(i <= end){
            result[points[i]] = interval[1] - interval[0] + 1;
            dsu.parent[i] = dsu.find(i + 1);
            i = dsu.parent[i];
        }
    }
}