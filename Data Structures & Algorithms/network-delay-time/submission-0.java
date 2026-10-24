/*

1. store in the input so that I can use it



*/



class Solution {

    static class Entry{
        int node;
        int distance;

        Entry(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Entry>> edges = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] time: times){
            edges.get(time[0]).add(new Entry(time[1], time[2]));
        }

        int[] bestTime = new int[n + 1];
        Arrays.fill(bestTime, Integer.MAX_VALUE);
        bestTime[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        minHeap.offer(new int[]{k, 0});
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            if(curr[1] > bestTime[curr[0]]) continue;

            List<Entry> neighbors = edges.get(curr[0]);

            for(Entry neighbor: neighbors){
                int arrivalTime = neighbor.distance + curr[1];

                if(arrivalTime < bestTime[neighbor.node]){
                    bestTime[neighbor.node] = arrivalTime;
                    minHeap.offer(new int[]{neighbor.node, arrivalTime});
                }
            }
        }
        int ans = 0;
        for(int i =1 ; i <=n ; i++){
            if(bestTime[i] == Integer.MAX_VALUE) return -1;

            ans = Math.max(bestTime[i], ans);
        }



        return ans;
    }
}
