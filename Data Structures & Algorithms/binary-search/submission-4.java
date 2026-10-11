/*
search element with logn time complexity

since sorted at any point we know at left there are small and at right there are large.

find mid and check if target is equal to mid then return index
if mid value is smaller thn target element is on right
else it is on left

at last if not found anything return -1;



*/


class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if( nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right  = mid - 1;
        }

        return -1;
    }
}
