/*
so we have an array and we have a window of k, in the ans array we need to have for each element the
max element when the element was on that windo

so I need to update the index at end when it leaves the window

for e.g

1 2 1 0 4 2 6

1 2 1 -> 2
2 1 0 -> 2
1 0 4 -> 4
0 4 2 -> 4
4 2 6 -> 6



2 2 4 4 6

if n then ans would be n - k


maintain min in window?

how to track if the min is added or removed
calculate min everytime?
won't it be expensive
n * k
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                deque.pop();
            }
            deque.push(i);
        }

        int left = 0;
        ans[left] = nums[deque.peekLast()];
        for (int right = k; right < n; right++) {
           
            if (left >= deque.peekLast())
                deque.pollLast();
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[right]) {
                deque.pop();
            }
            
            deque.push(right);

            left++;

            ans[left] = nums[deque.peekLast()];
        }

        return ans;
    }
}
