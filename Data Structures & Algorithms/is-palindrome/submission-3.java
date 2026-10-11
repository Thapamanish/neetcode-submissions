/*
find palindrome -> same if read from front or read from back - same thing

two pointer approach

start from left and right

and check left and right char (skip anything else then alphanumeric)

if found return false

at end return true


left = 0
right = 0

while left < right

    while left is not alphnumeric left++
    while right is not alphanumeric right--

    if charatleft != charAtRight return false



return truerue
*/
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            System.out.println(s.charAt(left) + " " + s.charAt(right));
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }
}

/*
left t a b
right t a
*/
