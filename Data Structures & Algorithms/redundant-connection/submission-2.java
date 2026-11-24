class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 1; i < edges.length + 1; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rootU = find(edge[0], parent);
            int rootV = find(edge[1], parent);

            if(rootU == rootV) return edge;

            parent[rootU] = rootV;
        }

        return new int[] {};
    }

    private int find(int x, int[] parent) {
        if (x != parent[x])
            parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
