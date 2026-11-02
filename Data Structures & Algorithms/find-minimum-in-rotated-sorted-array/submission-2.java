/*
we have to find in sorted rotated array

since sorted, we can use that
 we can implement a binary search

if we do it we have two scenario

1. either of one side is sorted and other is unsorted
2. we need to find which side is sorted first
2. we check in the sorted part first if the element is in the range
then redcue the serach range accordingly
3. if not then the element is in the unsorted part

I generally stuck with the range, since this is search we need to search l <= r

since this is not search but to find min so we should move the range in such a way that min is in
our left index

TC- O(logn)
SC - O(1)


*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // arry is sorted

                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
