/*
given array of integer, we need to find highest seqyuence(means any order) of continuous number.
what I mean is we need to find sequence which spans longest.

for e.g

2 20 4 5 3 21

here we have two sequence
2 3 4 5
20 21

we will return first one because it is the longest.

I will use a hasmap to solve it. so I will push everthing in the hashmap and traverse the integer
and check for ev ery integer if it has a previous value if yes skip if not then we got the first
element of the sequence. now increament the number till there is occurence of the number in the
hashset and side by side you increase the counter and once the condition becomes false you store max
value in the final answer.


TC -> O(n + 1 + s1 + s2)

SC - O(N)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) seen.add(num);
       
        int ans = 0;
        for (int num : nums) {
            if (seen.contains(num - 1))
                continue;
             int count = 0;
            while(seen.contains(num++)){
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
