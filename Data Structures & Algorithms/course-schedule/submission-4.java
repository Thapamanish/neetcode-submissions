class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[0];
            int u = prerequisite[1];

            adj.get(u).add(v);

            indeg[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0) queue.offer(i);
        }

        int idx = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();
            idx++;

            for(int neighbor: adj.get(u)){
                indeg[neighbor]--;
                if(indeg[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return idx == numCourses;
    }
}
