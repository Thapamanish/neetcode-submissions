/*
we have to remove

there could be one or more

should I remove the first overlapping?
let's try as soon as I found some overlappingn I remove

intervals=[[1,100],[11,22],[1,11],[2,12]]

this logic will fail for this
we should keep the one which is ending early

*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int[] last = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(last[1] > curr[0]){
                count++;
                if(curr[1] < last[1]) last = curr;
                continue;
            }
            last = curr;
        }

        return count;
    }
}
