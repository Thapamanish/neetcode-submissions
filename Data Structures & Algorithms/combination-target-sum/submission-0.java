/*
so we have nums

sort

then keep on adding the current until  == target if more then rmove and add another element
if more then add another back track and remove


skip if i == i - 1

TC - > 2^n




*/

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();


            check(nums, target, 0, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void check(
        int[] nums, int target, int start, int sum, List<Integer> curr, List<List<Integer>> ans) {
        if (start >= nums.length || sum > target)
            return;
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        
        curr.add(nums[start]);
        check(nums, target, start, sum + nums[start], curr, ans);
        curr.remove(curr.size() - 1);
        check(nums, target, start + 1, sum, curr, ans);
    }
}
