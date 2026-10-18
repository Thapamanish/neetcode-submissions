/*

we have to understood some condition

if x == y both destroy
if x < y  mean if unequal then |x - y|


we can do it by find two max until we have only one element
TC - > O(n * n)

but we can use a max heap to get repeatdly top two element
TC -> logn * n -> logn to heapify, n is repeat until n = 1;

SC - O(n)

*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            if (a - b != 0)
                maxHeap.offer(a - b);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
