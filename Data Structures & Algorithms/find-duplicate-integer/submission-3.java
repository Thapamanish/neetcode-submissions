/*
given array of integer, there is exactly one integer which is repeating we have to find that and
return. we can easily do it using a hashset.

TC - O(n)
SC - O(n)

but we are given one more information that numbers in the arry is in butween 1 to n inclusive so
which mean

if the range is 1 to 3

array size  = n + 1

than in array there should be 3 element

since the array size and array element in the range in the rance we can use the array element as
index and use the concept of slow and fast pointer slow pointer = nums[i] fast pointer =
nums[nums[i]]

since we are guarrented to have a repeated element then at some point slow and fast pointer will be
same and then we return the slow or fast value

TC -> O(n)
SC - O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

/*
slow 3 2
fast 2 2

*/
