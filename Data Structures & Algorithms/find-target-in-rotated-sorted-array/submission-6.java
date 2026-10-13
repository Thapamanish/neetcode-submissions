/*

given: an array with rotated n

we need to search the array to find the element


we can do it with O(n) linear serach


but what if we want to do with logn, we can use the property of binary serach but since rotated we
can check if given target is in left or right, but before that we need to find w



3 4 5 6 1 2

1

l = 0
r = 5

3 < 5

2 > 5 (False)


if(1 > 3 )

first see if current range is sorted or not if yes do simple binary search , if not search in the
sorted in the first then search in the non sorted



3 4 5 6 1 2

mid = 2

target 1

1 is on the rightso new range becomes

6 and 2

range is not sorted so go inside that statement and look for the sorted first yes it is there update
the right


TC - O(log n)
SC - O(n)
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
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

/*
I was able to do it , I felt boring to think of the solution, took some help to fix the bug in my
code


*/
