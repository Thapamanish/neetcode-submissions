/*

given a string, I have to find it is palindrome or not

palidrome -> if string is reversed it should be in same sequence of characters as original

catch -> only consider (alphanumeric - letters and numbers), igonre all other aspects like spaces, case, speacial characters.


approach : 1

String: with only aplhanumeric characters from the given string, change the case to lower and remove everything except alphanumeric values

reverse it 

then check both string

make a empty string then traverse the given string then make it lowercase and add only alphanumeric to new string ignore other

reverse it 

compare and return boolean


TC -> O(n) traversing the string + O(d) reverse d - string with only alphanumeric value
SC -> O(1) no extra space

*/
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;

        StringBuilder cleanString = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                cleanString.append(Character.toLowerCase(ch));
            }
        }
        
        String originalCleanString = String.valueOf(cleanString);
        String reversedCleanString = cleanString.reverse().toString();

        if(originalCleanString.equals(reversedCleanString)) return true;

        return false;


    }
}
