/*
we are given two string s1 and s2.

we have to find s1 in s2.


by finding any possible permutation of s1 as a substring in s2

s1 = abc
s2 = lecabee, lebacee

but not aceba


one thing we can do is find all the possible permuation of abc and and search in s2,
it would be very unefficient.

what if I do the use hash array?
while maintaining a window

I make a hasharray for s1
then I do it for s2 with same window as length of s1, if found return true else slide the window

at then end return false



TC -> O(n)
SC -> O(len(s1))

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] seenS1 = new int[26];
        int[] seenS2 = new int[26];

        for (char ch : s1.toCharArray()) {
            seenS1[ch - 'a']++;
        }

        int left = 0;
        int right = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            seenS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(seenS1, seenS2))
            return true;


        while (right < s2.length()) {
            seenS2[s2.charAt(left++) - 'a']--;
            seenS2[s2.charAt(right++) - 'a']++;
            if (Arrays.equals(seenS1, seenS2))
                return true;
        }

        return false;
    }
}
