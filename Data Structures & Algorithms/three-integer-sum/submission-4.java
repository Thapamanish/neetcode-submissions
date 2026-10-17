/*
3 loops and try each and other combo n3

2nd appraoch

sort
keep an anchor and then use two poniter

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                }

                else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }

        return triplets;
    }
}
