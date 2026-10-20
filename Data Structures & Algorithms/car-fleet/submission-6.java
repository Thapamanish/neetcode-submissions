class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] fleets = new int[position.length][2];

        for(int i = 0; i < position.length; i++){
            fleets[i][0] = position[i];
            fleets[i][1] = speed[i];
        }

        Arrays.sort(fleets, (a, b) -> Integer.compare(b[0], a[0]));

        double lastFleet = 0;
        int count = 0;

        for(int[] fleet: fleets){
            double rate = (double)(target - fleet[0]) / fleet[1];

            if(rate > lastFleet){
                count++;
                lastFleet = rate;
            }
        }

        return count;
    }
}
