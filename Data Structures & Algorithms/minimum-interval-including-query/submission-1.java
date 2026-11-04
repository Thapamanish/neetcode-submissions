/*
intervals[0] = start
intervals[1] = end


*/
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] derivedQuery = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            derivedQuery[i] = new int[] {i, queries[i]};
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(derivedQuery, (a, b) -> Integer.compare(a[1], b[1]));

        int idx = 0;

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            while (idx < intervals.length && derivedQuery[i][1] >= intervals[idx][0]) {
                int left = intervals[idx][0];
                int right = intervals[idx][1];
                minHeap.offer(new int[]{ right - left + 1, right});
                idx++;
            }
            while (!minHeap.isEmpty() && derivedQuery[i][1] > minHeap.peek()[1]) minHeap.poll();

            if (!minHeap.isEmpty())
                ans[derivedQuery[i][0]] = minHeap.peek()[0];
        }

        return ans;
    }
}
