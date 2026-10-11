class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        for(int num: nums){
            if(num == 0){

            zeroCount++;

            if(zeroCount == 2) return new int[nums.length];
            continue;
            }
            product *= num;
        }

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(zeroCount > 0){
                         if(nums[i] == 0){
                res[i] = product;

            } 
                            continue;
            }

            res[i] = product / nums[i];
        }

        return res;
    }
}  
