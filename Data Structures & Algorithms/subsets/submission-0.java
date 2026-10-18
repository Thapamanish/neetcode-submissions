class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        possibleSubsets(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void possibleSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> ans){
        if(start == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        // choose
        current.add(nums[start]);
        possibleSubsets(nums, start + 1, current, ans);
        // skip
        current.remove(current.size() - 1);
        possibleSubsets(nums, start + 1, current, ans);
    }
}
