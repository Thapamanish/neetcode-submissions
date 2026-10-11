/*
PROBLEM - given is a array of int, which are temperatures

we need to find for each temp, after how many min days we will see a warm temp. inshort currTemp < futureTemp, if not found any keep it 0


so I start ans array with 0


30 38 30 36 35 40 28


1  4  1  2  1  0  0


28 6
40 5

so I will use stack and take advantage of monotonic advantage,
which is store if smaller but if bigger pop until it is small or stack is empty, while poping sub the index and store it in ans array

tC - O(N)
SC - O(1)



*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();

        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
              int prevIdx = stack.pop()[1];
              ans[prevIdx] = i - prevIdx;
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return ans;

    }
}
