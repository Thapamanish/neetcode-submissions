/*
I think this is easy , we just need to check if the there is any confilct between the interval

prev.end < curr.start

considering everything is sorted

so it is not sorted

I will sort it in asce

tC - O(nlogn)
SC - O(1)

*/

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 1) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if (curr.start < prev.end)
                return false;
            prev = curr;
        }
        return true;
    }
}
