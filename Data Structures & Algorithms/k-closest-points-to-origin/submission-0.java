/*
we nee to find the distance of all the points we have then put it in the max heap with size k and
then return that.

TC -> nlogk

SC - O(k)


*/

class Solution {
    static class Closer {
        int[] point;
        double distance;
        Closer(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Closer> maxHeap =
            new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        for (int[] point : points) {
            double dist = findDistance(point[0], point[1]);
            System.out.println(dist);
            maxHeap.offer(new Closer(point, dist));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] ans = new int[k][2];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            ans[idx++] = maxHeap.poll().point;
        }

        return ans;
    }

    private double findDistance(int p, int q) {
        System.out.println(p + "--" + q);
        return Math.sqrt(p * p+ q * q);
    }
}
