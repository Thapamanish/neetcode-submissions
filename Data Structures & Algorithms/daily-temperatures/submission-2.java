/*
I have to find a temp in future which warmer than today


so for this I am seeing monotonic behaviour I am not able to answer currently buut I will get the
answer in the future so I ahve to store it somewhere so I will store it in the stack and if I find a
warmer temperature I will pop until the curr temp is tha highest. I will calculate the day
difference while poping

TC - O(n)
SC - O(1)


*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }
        return ans;
    }
}
