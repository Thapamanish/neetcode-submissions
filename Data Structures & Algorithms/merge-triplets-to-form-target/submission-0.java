class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] temp = new int[3];

        for(int i = 0 ; i < triplets.length; i++){
            int[] curr = triplets[i];
            int a = Math.max(curr[0], temp[0]);
            int b = Math.max(curr[1], temp[1]);
            int c = Math.max(curr[2], temp[2]);

            if(a <= target[0] && b <= target[1] && c<= target[2]){
                temp = new int[]{a, b, c};
            }
        }

        return Arrays.equals(temp, target);
    }
}
