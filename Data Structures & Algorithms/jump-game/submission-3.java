class Solution {
    public boolean canJump(int[] nums) {

        // return canReach(nums, 0);

        boolean[] visited = new boolean[nums.length];
        visited[0] = true;

        int n = nums.length - 1;

        for (int i = n; i >= 0; i--) {
            int j = i;
            while (j >= 0 && !visited[i]) {
                j--;
                if (j >= 0 && j + nums[j] >= i)
                    visited[i] = true;
            }


            if (!visited[i])
                return false;
        }
        return visited[0];
    }

    private boolean canReach(int[] nums, int start) {
        if (start >= nums.length - 1)
            return true;

        for (int i = 1; i <= nums[start]; i++) {
            if (canReach(nums, start + i))
                return true;
        }
        return false;
    }
}
