/*
given: is array of integers

I have to find the triplets whose sum is 0.

I can use 3 for loops and find it but it would make the TC as O(n^3)

So, I sort the array first O(nlogn)

then I traverse,

keeping one pointer stable and using other two pointer to find the total sum to 0. using two pointer
techniqe to make the sum equal to target

if find ans put it in the ans array and at last return it.

I have to take care of the duplicates so for the traversal I don't repeat same element again

-4, -1, -1, 0, 1, 2

TC - nlogn + n * n = > O(n^2)
SC - O(1)



*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }

        return triplets;
    }
}

/*
nums[left] + nums[right] == nums[i]

*/