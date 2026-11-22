class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                queue.offer(i);
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            completed++;
            int curr = queue.poll();
            List<Integer> neighbors = adj.get(curr);

            for (int neighbor : neighbors) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return completed == numCourses;
    }
}
