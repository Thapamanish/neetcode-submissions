/*
goal to find if there are two nummbers which sum up to the target, if yes return the two index i and
j which makes the sum and i < j


use hasmap ele: index to store already seen ele and keep subtracting with the new element the target
and if the diff is found in hasmap we already saw it

TC - O(n)
SC - O(n)


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (seen.containsKey(diff))
                return new int[] {seen.get(diff), i};
            seen.put(nums[i], i);
        }

        return new int[] {};
    }
}
