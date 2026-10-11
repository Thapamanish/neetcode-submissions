
/*
find 3 number whose sum is equal to 0.

can do it with 3 loops but it would be O(n3) TC

instead we can sort the array and then keep one loop and inside it use two pointer approach to to
make sum zero utiliseing the sorted property.

1 2 3 4

keep 1
l = 2
r = 4


oops the question is about two sum with a sorted array, totally misread the problem. here we just
use two pointer approach if left + right < target increase left else decrease right

tC -> O(n)
SC -> O(n)


*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[] {left + 1, right+ 1};
            else if (sum < target)
                left++;
            else
                right--;
        }

        return new int[] {};
    }
}
