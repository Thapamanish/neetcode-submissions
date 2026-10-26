/*
We have to find the square of each digit and then check if it is already visited. we can track that
with the help of a hashset

TC -> O(d * x) -:> length of longest digit and x is until we found 1 or we found duplicate

SC - O(x)

*/
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n))
                return false;
            seen.add(n);
            n = square(n);
        }

        return true;
    }

    private int square(int n) {
        int squaredValue = 0;

        while (n != 0) {
            int rem = n % 10;
            squaredValue += rem * rem;
            n /= 10;
        }

        return squaredValue;
    }
}
