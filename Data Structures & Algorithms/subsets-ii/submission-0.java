/*

we need to sort the given array

and skip if the current and prev element is same

*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, ans, 0, new ArrayList<>());

        return ans;
    }

    private void solve(int[] nums, List<List<Integer>> ans, int start, List<Integer> curr) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[start]);
        solve(nums, ans, start + 1, curr);
        curr.removeLast();

        while(start + 1 < nums.length && nums[start] == nums[start + 1]) start++;
        solve(nums, ans, start + 1, curr);
    }
}
