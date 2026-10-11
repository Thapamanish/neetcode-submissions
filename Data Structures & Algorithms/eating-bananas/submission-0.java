class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = 0;

        for(int pile: piles){
            maxElement = Math.max(maxElement, pile);
        }

        int l = 1;
        int r = maxElement;

        int finalEatingRate = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(canEatWithinTime(mid, h, piles)){
                finalEatingRate = Math.min(finalEatingRate, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return finalEatingRate;
    }

    public boolean canEatWithinTime(int rate, int h, int[] piles){
        int count = 0;

        for(int pile: piles){
            count += (pile + rate - 1) / rate;
        }

        return count <= h;
    }
}
