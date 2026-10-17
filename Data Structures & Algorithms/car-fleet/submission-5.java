/*

we have position and speed, we need need to find number of fleets they reach in the destination


so find how long does it take to reach

then travesre and see if the next time is < if yes then include it in the fleet other wise create a new flee


TC - O(nlogn) 

SC - O(1)


*/


class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleetTime = 0.0;
        for(int[] car: cars){
            double newTime =  (double)(target - car[0]) /car[1];
            if(newTime <= lastFleetTime) continue;
            fleets++;
            lastFleetTime = newTime;
        }

        return fleets;
    }
}
