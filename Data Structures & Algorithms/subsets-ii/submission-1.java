class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int[] nums, int start, List<Integer> curr, List<List<Integer>> ans){
        if(start == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
       
        curr.add(nums[start]);
        solve(nums, start + 1, curr, ans);
        curr.remove(curr.size() - 1);
        while(start + 1 < nums.length && nums[start] == nums[start + 1]) start++;
        solve(nums, start + 1, curr, ans);
    }
}
