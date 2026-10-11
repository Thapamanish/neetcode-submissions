class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int first = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = n - 1;

            while(low < high){
                int tripletSum = first + nums[low] + nums[high];

                if(tripletSum == 0){
                    res.add(List.of(first, nums[low], nums[high]));
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low - 1]) low++; 
                    while(low < high && nums[high] == nums[high + 1]) high--;
                } else if(tripletSum > 0) high--;
                else low++;
            }
        }

        return res;
    }
}
