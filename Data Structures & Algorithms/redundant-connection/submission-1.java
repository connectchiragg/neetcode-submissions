class DSU {
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        if(size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return true;
    }

    public int find(int a){
        while(a != parent[a]){
            parent[a] = find(parent[a]);
            a = parent[a];
        }

        return parent[a];
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for(int[] edge : edges){
            if(!dsu.union(edge[0] - 1, edge[1] - 1)) return edge;
        }

        return new int[0];
    }
}
