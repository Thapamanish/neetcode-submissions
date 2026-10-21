class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[0] = 0;
        int total = 0;
        boolean[] isVisited = new boolean[n];

        for (int added = 0; added < n; added++) {
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (!isVisited[v] && (u == -1 || best[v] < best[u]))
                    u = v;
            }

            isVisited[u] = true;
            total += best[u];
            for (int v = 0; v < n; v++) {
                if (isVisited[v])
                    continue;

                int cost =
                    Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);

                best[v] = Math.min(best[v], cost);
            }
        }

        return total;
    }
}
