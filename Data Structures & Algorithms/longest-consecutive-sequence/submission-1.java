class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int bestCount = 1;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            int currCount = 1;
            int curr = nums[i];
            for(int j = i + 1; j < n; j++){
                if(curr + 1 == nums[j]){
                    currCount++;
                    curr = nums[j];
                }
            }
            bestCount = Math.max(bestCount, currCount);
        }

        return bestCount;
    }
}
