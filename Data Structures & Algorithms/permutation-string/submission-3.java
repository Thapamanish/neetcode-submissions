/*
so we have to find s1 is in s2 or not, we can do it my finding every possible permutation of s1 and
then search it in the s2 but it would be very expensive

so we will be using a hash array and then store s1 in it and subract s2 char from it and finally
check if the hasharray is 0 or < if yes it is present if not then return false;


nope I thought wrong, we have to slide the window and chek if in that window if both are correct
because we have to check substring

TC - O(n)
SC - O(1)
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;
        int[] seenS1 = new int[26];
        int[] seenS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            seenS1[s1.charAt(i) - 'a']++;
            seenS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(seenS1, seenS2))
            return true;
        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {
            seenS2[s2.charAt(right) - 'a']++;
            seenS2[s2.charAt(left) - 'a']--;
            left++;
            if (Arrays.equals(seenS1, seenS2))
                return true;
        }

        return false;
    }
}
