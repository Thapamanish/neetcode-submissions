

/*
we have merge all the interval

so we should compare 2 interval at once

we should take one interval to compare 

so we make a new ans array

and traverse the given array from 2

compare 2 with first interval

if merged then merge and continue to another

if no then add the current and move ahead and make the new interavl as new base check

since it is not saying if the intervals are sorted or not. then we need to sort it
TC - > O(n)
SC - O(1)


*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] compare = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            // no overlapping
            if(compare[1] < intervals[i][0]) {
                merged.add(compare);
                compare = intervals[i];
            } else {
                compare[0] = Math.min(compare[0], intervals[i][0]);
                compare[1] = Math.max(compare[1], intervals[i][1]);
            }
        }

        merged.add(compare);

        return merged.toArray(int[][]::new);
    }
}
