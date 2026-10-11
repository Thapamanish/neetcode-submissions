class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            Integer j = indexByValue.get(needed);
            if (j != null) return new int[]{j, i};

            indexByValue.put(nums[i], i);
        }

        return new int[0];
    }
}
