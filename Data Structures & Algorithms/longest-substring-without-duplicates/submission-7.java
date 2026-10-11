/*
we have string s = "xyzyzz"

find : maxlen(substring with unique char in it)


maintain a string with unique chars

window
left = 2
right = 4

hasmap
travese
x: 0
y: 3
z: 4
y

left = 2 + 1 = 3
right = 0

while (left <= right)

ans = max(ans, right - left + 1) // 3,  4 - 2 => 2

ans = 0 1 2 3 


TC -> O(n)
SC -> O(n)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int ans = 0;
        
        for(int right = 0; right < s.length(); right++){
            char currKey = s.charAt(right);
            if(freq.containsKey(currKey)){
                left = Math.max(left, freq.get(currKey) + 1);
            }
            freq.put(currKey, right);
            ans = Math.max(ans, right - left + 1);
        
        }

        return ans;
    }
}

/*
left = 0, 0 + 1 = 1, 
right = 0 1 2 3


{
a: 0
b: 1
 }

 ans = 2 , 2 - 1 + 1 = 2 ,

*/
