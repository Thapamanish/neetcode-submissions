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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for(Interval interval: intervals){
            int start = interval.start;
            int end = interval.end;

            if(!minHeap.isEmpty() && start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(end);
        }

        return minHeap.size();
    }
}
