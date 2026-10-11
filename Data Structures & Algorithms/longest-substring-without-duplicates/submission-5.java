/*
xzyzx


map= {x:0, z:3, y:2 }

left =1 + 1 =2


right = 3

ans = max(ans, right - left + 1)


Since I have to maintain a unique substring, I will make window by using two pointers left and
right. I will also keep a map, which will store the element and their index. As I traverse I will
store it in the map and update my ans by sub right -left + 1. now there is be point where our
condition fails which is when I find exisiting element in map. then I will check if the index is
smaller then left if yes then just update the index of conflicted element if no then it means we
have to move our window, we update our left as old conficted value + 1 and update the map element
with new value and update the ans. and once the traversal ends we return the ans.

TC -> O(n) for traversal of input string
SC -> O(m) m is distinct element for storing in map

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0, right = 0;
        Map<Character, Integer> pos = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (pos.containsKey(ch)) {
                if (pos.get(ch) < left) pos.put(ch, right);
                else {
                    left = pos.get(ch) + 1;
                    pos.put(ch, right);
                    ans = Math.max(ans, right - left + 1);
                }
            } else {
                pos.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
