/*
so the question is says we have array nums and o/p is also an array with each element with product of all other element except itself

1 2 4 6

o/p -> 48 24 12 8

but if input is 0 then

-1 0 1 2 3

0 -6 0 0 0

brute force would be use two for loops and multiply all except itself. TC - O(n2)

what are we repeating ? we are doing same thing again and again
1 2 4 6

1 1 1 1

1 1 2 8
48 24 12 8


prefix = first element
start finding from 2

suffix = last element
start finding from second last element

return the final array


TC - O(n)
SC - O(1)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];

        Arrays.fill(productArray, 1);

        int prefix = nums[0];
        int suffix = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            productArray[i] *= prefix;
            prefix *= nums[i];
        }

        for(int i = nums.length - 2; i >= 0; i--){
            productArray[i] *= suffix;
            suffix *= nums[i];
        }

        return productArray;
    }
}  
