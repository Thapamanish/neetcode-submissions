/*
We nee dto find if the given string is palindrome or not irrespective of any special chars. only
alphanumeric character should be considered.

I will use two pointer and ignore if not aplha numeric otherwise just check left and right if they
are equal

at any instance if it is false return false

at the end return true

TC -> O(n)
Sc -> O(1)

*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            
            left++;
            right--;
        }

        return true;
    }
}
