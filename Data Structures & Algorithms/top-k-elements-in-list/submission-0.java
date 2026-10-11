class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));


        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            maxHeap.offer(new int[]{key, value});

            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[] res = new int[k];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            res[idx++] = maxHeap.poll()[0];
        }

        return res;
    }
}
