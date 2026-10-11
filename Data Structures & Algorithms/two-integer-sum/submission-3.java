/*
use two for loops and check evvery element with another but it is expensive TC -> O(n^2)

I can trade the TC with SC. I can use a hashmap since I need index also. so I will traverse the array and as I go I will search target - curr is in the hashmap or not, if yes then we found the two element if not just put in the hashmap and move ahead

TC - O(n) - traversing through the array
SC - O(n) - hashmap


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(seen.containsKey(complement)) return new int[]{seen.get(complement), i};
            else seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
