/*
here we have piles of banana, and total hour before which koko has to eat the all banana in the pile

we have to find the rate at which koko can eat the banana because with whihc if it eats the banana
it can complete the pile. one catch is if the pile is eompleled early koko can't go to next pile
until another hour

e.g

1 4 3 2 total = 9

if koko eats 4 banana every hour it can complete eating in just 4 hours

bue we need to find min rate / hour

what if koko eat 2 bana every hour

then
1 -> 1 fully
4 -> need 2 hours
3 -> need 2 hour
2 -> need 1 hour


so koko eat 2/hour it can finish it in 6 hours <= 9

so if we see here we see a we have to find a range between 1 to max(piles) nd we can do it with
binary search instead of trying all

TC-> O(n) * O(klogk) -> k is the max(piles)
SC -> O(1)

*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEat(mid, piles, h))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public boolean canEat(int rate, int[] piles, int h) {
        int ans = 0;
        for (int pile : piles) {
            ans += (pile + rate - 1) / rate;
        }
        return ans <= h;
    }
}
