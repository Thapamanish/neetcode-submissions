/*
given array of integer

output is array of integer, each element should be product of array except itself


1 2 4 6

o/p: 48 24 12 8


we can do it in two traversal

1st

replace ans array curr value with prefix till prev val then multiply with current

2nd

start from end and multply existing ans array curr value with suffix product val till previous 



prefix = 1

1st pass
ans[i] = prefix
prefix *= nums[i]


suffix = 1
2nd pass

ans[i] *= suffix
suffix *= nums[i]


return ans


TC - O(n)
SC - O(1) if not counted the ans array

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1, suffix = 1;

        for(int i = 0; i < n; i++){
            output[i] = prefix;
            prefix *= nums[i];
        }

        for(int i = n - 1; i >= 0; i--){
            output[i] *= suffix;
            suffix *= nums[i];
        }

        return output;
    }
}  
