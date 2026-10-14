/*

searching with in an array would be easy with linear search but we need to do better since we have a
sorted array


what we can do is we can find a sorted side then check if the element is in that range if not then
take this range out of the search scan

e.g

3 4 5 6 1 2

binary serach

left = 0
right = 5

mid = 2

check if mid is the answer if not

then ceck before mid is sorted or after

target 1 is < left so we know it doesn't lie in this range

so left = mid + 1

we do it unitl we find


TC - O(logn)
SC- O(1)

*/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
