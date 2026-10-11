class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if(k > n) return new int[]{};

        int[] res = new int[n - k + 1];


        Deque<Integer> dq = new ArrayDeque<>();

        int right = 0;
        int left = 0;
         
        while( right < n){

            while(!dq.isEmpty() && dq.peek() <= right - k ){
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right])
                dq.pollLast();

            dq.offerLast(right);

            if(right >= k - 1){
                res[right - k + 1] = nums[dq.peekFirst()];
            }

            right++;
        }

        return res;
    }
}
