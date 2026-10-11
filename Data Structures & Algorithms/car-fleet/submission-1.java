class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] pairs = new double[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double lastFleet = 0;
        for(int i = 0; i < n; i++){
            double currTime = pairs[i][1];

            if(currTime > lastFleet){
                count++;
                lastFleet = currTime;
            }
        }

        return count;
    }
}
