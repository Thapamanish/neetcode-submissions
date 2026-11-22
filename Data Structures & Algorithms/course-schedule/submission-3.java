class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, i, state))
                return false;
        }

        return true;
    }

    public boolean hasCycle(List<List<Integer>> adj, int curr, int[] state) {
        if(state[curr] == 1) return true;
        if(state[curr] == 2) return false;
        List<Integer> neighbors = adj.get(curr);
          state[curr] = 1;
        for (Integer neighbor : neighbors) {
            if (hasCycle(adj, neighbor, state))
                return true;
            
        }
        
        state[curr] = 2;

        return false;
    }
}
