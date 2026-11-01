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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for(Interval interval: intervals){
            if(!ends.isEmpty() && ends.peek() <= interval.start) ends.poll();

            ends.offer(interval.end);
        }

        return ends.size();
    }
}
