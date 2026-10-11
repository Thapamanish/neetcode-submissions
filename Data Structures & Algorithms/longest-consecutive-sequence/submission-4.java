class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        Set<Integer> seen = new HashSet<>();

        for(int x: nums){
            seen.add(x);
        }

        int best = 0;

        for(int x: seen){
            if(!(seen.contains(x - 1))){
                int len = 1;
                int curr = x;

                while(seen.contains(++curr)){
                    len++;
                }

                best = Math.max(len, best);
            }
        }

        return best;

    }
}
