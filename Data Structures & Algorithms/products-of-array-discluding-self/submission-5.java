/*
at each element only the product of left and right element should be the result at that index without including itself.

we can use prefix and suffix approach to solve this

find the prefix and store in the index without including itself, do the same for the suffix

TC - O(n + n)
SC - O(1)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < nums.length; i++){
            ans[i] = prefix;
            prefix *= nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}  
