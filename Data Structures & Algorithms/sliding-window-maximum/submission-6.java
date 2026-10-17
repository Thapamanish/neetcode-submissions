/*
we have to find max of 3 elements so as a new element is introduced the max can change and when the
element leave the max element can also change

so I will use a stack to maintain the large element and as soon as it out of the range I pop it

basically one side will act as stack and another side will act as queue
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!stack.isEmpty() && nums[right] > nums[stack.peek()]) {
                stack.pop();
            }

            stack.push(right);

            if (right >= k - 1) {
                if (left > stack.peekLast()) {
                    stack.pollLast();
                }
                ans[left++] = nums[stack.peekLast()];
            }
        }

        return ans;
    }
}
