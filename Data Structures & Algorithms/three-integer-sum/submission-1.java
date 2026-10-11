/*
find 3 numbers whose sum is 0.

-1,-1,2

no duplicate

-1,-1,2 -> -1,2-1

-1,0,1
-1,0,2
-1,0,-1

O(n3)

first
sort
one anchor pointer
the other two two as the moving pointer

-4,-1,-1,0,1,2

p1 = -1
p2 = -1
p3 = 2


sum = 0 < 0

ans = [-1,-1, 2]


TC - O(nlogn) + O(n * (n - 1) ) -> O(n2)
SC - O(1)

while current pointer value is not equal to last pointer val


*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);


        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

        int left = i + 1;
        int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }

        return ans;
    }
}
