/*
we have to find all the possible way to reach n

let's break this into smaller problem how can we reach a staircase

either by n - 1 or n - 2

so if I have to reach n, I have to know how can I reach n - 1 and n - 2

we can solve this with recursion 
TC - O(n)
SC - O(h)

we can do this with dp as well

TC - O(n)
SC - O(1)


*/

class Solution {
    public int climbStairs(int n) {
        // if(n == 0 || n == 1) return 1;

        // return climbStairs(n - 1) + climbStairs(n - 2);

        int oneStep = 1, twoStep = 1;
        if(n == 1) return oneStep;
        int steps = 0;
        for(int i = 2 ; i<= n; i++){
            steps = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = steps;
        }
        return steps;
    }
}
