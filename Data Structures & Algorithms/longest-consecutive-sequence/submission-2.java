class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int bestCount = 1;
        Arrays.sort(nums);
        int curr = nums[0];
        int currCount = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == curr) continue;
            if(nums[i] != curr + 1){
                currCount = 1;
            } else {
                currCount++;
            }
            curr = nums[i];
            bestCount = Math.max(bestCount, currCount);
        }

        return bestCount;
    }
}
