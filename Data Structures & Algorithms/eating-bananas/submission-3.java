/*
so we ahve array of integers piles and a number h = 9

koko have to finish all the banana in atmost h hours

each pile can be eaten atmost at once or can be eaten in parts but if there is extra time reaminin we can't go to another pile until the time is completed

we have to find min time (eating rate) with which eating all the piles could be complete <= h


so we have to calculate rate of eating
so lowest a koko can eat 1 banana per hour and max it can it Max(piles)

now we have to adjust the rate in such a way we find min rate and piles can be completed in <= h

it is kinda binary problem where we try mid element and if we finish eating within time we reduce the time and see and if not we increase the time and seee. all this time track the min rate.

TC -> O(log(max(piles)) * n)

SC -> O(1)

2 / 2 -> 1

1 / 2 - > 0

3 / 2 -> 1

2 + 2 - 1 / 2 -> 1

1 + 2 - 1 / 2 = 1

3 + 2 - 1 /2 

*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile: piles){
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1, right = maxPile;
        int rate = maxPile;

        while(left <= right){
            int mid = left + (right - left) /2;

            int totalHours = 0;
            for(int i = 0; i < piles.length; i++){
                totalHours += (piles[i] + mid - 1) / mid;
            }

            System.out.println("------" + mid + "-------" + totalHours);
            if(totalHours <= h){
                rate = Math.min(rate, mid);
                right = mid - 1;
            } else {
                 left = mid + 1;
                
            }

        }

        return rate;
    }
    
}
