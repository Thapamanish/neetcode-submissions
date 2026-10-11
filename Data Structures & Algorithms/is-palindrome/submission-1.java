class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int n = arr.length;

        int low = 0;
        int high = n - 1;

        while(low < high){
            while(!Character.isLetterOrDigit(arr[low]) && low < high) low++;
            while(!Character.isLetterOrDigit(arr[high]) && low < high) high--;

            if(arr[low] != arr[high]) return false;

            low++;
            high--;
        }

        return true;


    }
}
