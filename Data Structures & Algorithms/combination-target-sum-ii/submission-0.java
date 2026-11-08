/*
we can use same element once but if there are multiple elements with same value we can use that

1 2 3 1

1 1 2 is okay

but again 1 1 2 is not okay

we have two choice at each point whether to keep it or not keep it

that is why time complexitiy is 2^n but we need to sort as well to avoid duplicate

so tc - O(nlogn) + O(2^n)
Sc- O(n)
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        solve(candidates, target, ans, new ArrayList<>(), 0);

        return ans;
    }

    public void solve(
        int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int start) {
        if (target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (start >= candidates.length || target < 0)
            return;

        curr.add(candidates[start]);
        solve(candidates, target - candidates[start], ans, curr, start + 1);
        curr.remove(curr.size() - 1);
        while (start + 1 < candidates.length && candidates[start] == candidates[start + 1]) start++;
        solve(candidates, target, ans, curr, start + 1);
    }
}
