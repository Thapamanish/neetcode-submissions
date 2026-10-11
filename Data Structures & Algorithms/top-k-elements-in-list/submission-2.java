class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);

        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            int value = entry.getValue();
           if(bucket[value] == null){
            bucket[value] = new ArrayList<>();
           }
           bucket[value].add(entry.getKey());
        }


        int[] res = new int[k];
        int idx = 0;

        for(int i = bucket.length - 1; i >= 0 && idx < k; i--){
            if(bucket[i] == null) continue;

            for(int x: bucket[i]){
                res[idx++] = x;
                if(idx == k) break;
            }
        }

        return res;
    }
}
