/*

bitwise operator  right shift shift the bit on right and add that in the total.

ans += n >> 1 


*/

class Solution {
    public int hammingWeight(int n) {
        int ans = 0;

        while(n != 0){
            ans += n & 1;
            n = n >> 1;
        }

        return ans;
    }
}
