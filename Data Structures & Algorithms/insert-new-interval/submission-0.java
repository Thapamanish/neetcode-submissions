/*
we hav to add a interval in between exisitng if overlapped merge them


*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i;
        for(i = 0; i < intervals.length; i++){
            int[] currInterval = intervals[i];

            if(currInterval[1] < newInterval[0]){
                ans.add(currInterval);
            } else if(newInterval[1] < currInterval[0]){
                break;
            }
            else {
                int m = Math.min(currInterval[0], newInterval[0]);
                int n = Math.max(currInterval[1], newInterval[1]);
                newInterval = new int[]{m, n};
            }

        }

        ans.add(newInterval);

        while(i < intervals.length){
            ans.add(intervals[i++]);
        }

       return ans.toArray(int[][]::new);
    }
}
