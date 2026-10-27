/*
at each num we have two choices either make it positve or make it negative

we can do it by sorting and trying everypossiblity.

TC -> O(nlogn + 2^n)
SC -> O(h) stack size
 so we have to make sure that we use all number

*/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        List<Map<Integer, Integer>> seen = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            seen.add(new HashMap<>());
        }
        return solve(nums, target, 0, seen);
    }

    private int solve(int[] nums, int target, int start, List<Map<Integer, Integer>> seen) {
        if (start == nums.length) {
            if (target == 0)
                return 1;

            return 0;
        }

        Integer cached = seen.get(start).get(target);

        if (cached != null)
            return cached;

        int ways = solve(nums, target - nums[start], start + 1, seen)
            + solve(nums, target + nums[start], start + 1, seen);

        seen.get(start).put(target, ways);

        return ways;
    }
}
