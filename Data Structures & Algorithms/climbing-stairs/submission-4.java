class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int oneStep = 2;
        int twoStep = 1;
        for(int i = 3; i <= n; i++){
            int newStep = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = newStep;
        
        }

        return oneStep;
    }
}




