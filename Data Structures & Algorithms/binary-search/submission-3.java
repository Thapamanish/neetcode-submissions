/*
evidence

array is sorted

brute foce search linearly O(n)

but array is sorted we can use binary search with logn time complexity and O(1) as space

two pointer left and right

beginning and end

see if mid is the target


if not since array is sorted 

if target > mid increaase left to mid + 1 else decrease right to mid - 1



*/


class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
