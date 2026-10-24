/*
j <= nums[i]

what does this mean?

oh okay j is basically any numnber equal to or less than num[i]

so I can start from first index and try all the possible ways then start from second and try all the
possible ways but I can always memo the the count

like if I start from 2 and then go to 4 then when I start from 4 I have explored every possible way
from 4 and I don't need to do it again


we need to find the minimum

can we start from end?

2 . 0 -> 4 . 1 , 1 . 2

so I make a memo of n then store the value there I start with -1 and then at the end I return
memo[0]


*/

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        return solve(nums, 0, best);
    }

    private int solve(int[] nums, int start, int[] best) {
        if (start >= nums.length - 1)
            return 0;

        if (best[start] != Integer.MAX_VALUE)
            return best[start];
        for (int i = 1; i <= nums[start]; i++) {
            best[start] = Math.min(best[start], solve(nums, start + i, best));
        }

        if (best[start] != Integer.MAX_VALUE)
            ++best[start];


        return best[start];
    }
}
