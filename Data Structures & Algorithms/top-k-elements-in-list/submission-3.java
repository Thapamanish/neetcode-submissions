/*
need to find k most frequent elements

for e.g

1 2 2 3 3 3 

o/p - 2 3 (any order is okay)


we can use heap to solve this

use min heap which will have small element on the top but we will only store top k element in heap so the size of the heap will k

so we push in the heap and as soon as size is > k then pop smallest so that we can always only max count elements

willl use hashmap to count the elements in the array


after traversal return the all the elements in min heap

TC -> O(n) * O(logk) -> n for traversal and k for heapifying

SC - O(distinct(n) + k) -> map + heap size


*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> ele: freq.entrySet()){
            minHeap.offer(new int[]{ele.getKey(), ele.getValue()});

            if(minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];

        int idx = 0;
        while(!minHeap.isEmpty()){
            ans[idx++] = minHeap.poll()[0];
        }

        return ans;
    }
}
