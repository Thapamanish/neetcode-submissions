/*
we can use priority queue - min heap to solve this of size k

add to the queue as soon as it exceed size k pop and at the end return the top of the queue

TC -> log(n)

SC - O(k)



*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.offer(num);

            if(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
