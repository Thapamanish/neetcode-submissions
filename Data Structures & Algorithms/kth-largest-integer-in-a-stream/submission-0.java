/*
We need to return k largest element every time we add any new value.

So it means every time we add value there is chance that the k largest element could change.

simplest way to do it is we can sort everytime we add then return nums[k - 1] but it would be
expensive as sorting is O(nlogn)


But we can use min heap with size k so we will pop as soon as heap is greater than k so that the top
element is always k largest

so othe time complexityt would be O(logk), logk is to heapify



*/

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int kth;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        kth = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > kth)
            minHeap.poll();

        return minHeap.peek();
    }
}
