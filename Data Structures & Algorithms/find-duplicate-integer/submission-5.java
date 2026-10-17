/*
we can sort and find the duplicate nums[i] == nums[i - 1]
we can use hashmap

but both have TC and SC trade offs.

we can use slow and fast pointer to do it

similar to linked list we will find the beginning of the loop and that is the duplicate number

TC - O(n)
SC - O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

