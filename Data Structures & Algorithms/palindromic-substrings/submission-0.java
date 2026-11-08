/*
traverse the string and go left and right from it and if matches make it count 

but what if the length is even?


abc
= 3

aaa
1
2
3
4
5
6

abbc
aab

*/

class Solution {
    public int countSubstrings(String s) {
        int count = 1;
        for(int i = 1; i< s.length(); i++){
            count++;
            if(s.charAt(i - 1) == s.charAt(i))
                count += isPalindrome(i - 1, i, s);

                 count += isPalindrome(i - 1, i + 1, s);

        }
        return count;
    }

    public int isPalindrome(int left, int right, String s){
        int n = s.length();
        int count = 0;
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}
