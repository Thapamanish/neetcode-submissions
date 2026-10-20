/*
new interval could
1. placed in between
2. could overlap


as soon as it is placed in between we no further need to traverse.

but if it overlaps we need to update the new interval 

such that

start = Math.min(old start, new start)


end = Math.max(old end, new end)

2, 5

1 3

3 6

1 6


*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> ans = new ArrayList<>();
        while(i < intervals.length){
            if(intervals[i][1] < newInterval[0] && intervals[i][1] < newInterval[0]){
                ans.add(intervals[i]);
                i++;
            } else if(intervals[i][0] > newInterval[0] && intervals[i][0] > newInterval[1]){
                break;
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

                i++;
            }
        }

        ans.add(newInterval);

        while(i < intervals.length){
            ans.add(intervals[i++]);
        }

        return ans.toArray(new int[0][]);
    }
}
