/*
we need to find the k largest

at any point of time even if added or removed

so simply we need to sort it everytime something is added or removed
that is why we use DS minheap is sorts as soon as some thinge is added and removed

O(1) insert
O(log n) heapify

nlogn inital push

logn after every push



*/
class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > k) minHeap.poll();

        return minHeap.peek();
    }
}
