class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[] {v, t});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        dist[k] = 0;
        minHeap.offer(new int[] {k, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0];
            int t = curr[1];

            if (t > dist[u])
                continue;
            List<int[]> neighbors = adj.get(u);
            for (int[] neighbor : neighbors) {
                int v = neighbor[0];
                int w = neighbor[1];

                if (w + t < dist[v]){
                    dist[v] = w + t;
                    minHeap.offer(new int[] {v,dist[v]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(dist[i], ans);
        }

        return ans;
    }
}
