/*


we have to use backtracking to do this

travese and change the decision .

we need to  include all numbers

but in different sequence


we can use recursoin and use a for loop in side the recursive function


*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void solve(
        int[] nums, List<List<Integer>> result, List<Integer> curr, Set<Integer> seen) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (seen.contains(num))
                continue;
            seen.add(num);
            curr.add(num);
            solve(nums, result, curr, seen);
            curr.removeLast();
            seen.remove(num);
        }
    }
}
