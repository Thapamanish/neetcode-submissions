/*

two conditions that we need to follow is
1. arrange in group of groupSize
2. increaseing ordering


if it is possible to arrange return true
else false


make an hash array til the max number

then start traversiong and if we find any break return false

else truen true;

TC - O(n);
SC - O(n);

I got the question wrong

so if there is group size we need to find if there are groups and of size group size

can we have a set

we can't have set but we can have a map

then traverse the given array and and see if it is the first element of sequence and if yese travers
until groupSize and remove as we go and if not found return false

at the end return true;
1,2,3,6,2,3,4,7,8

1 2 3
2 3 4
6 7 8

*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int num : hand) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            if (!seen.containsKey(num))
                continue;

            while (seen.containsKey(num - 1)) {
                num = num - 1;
            }

            int i = 0;

            while (i < groupSize) {
                int key = num + i;
                if (!seen.containsKey(key))
                    return false;
                seen.put(key, seen.get(key) - 1);
                seen.remove(key, 0);
                i++;
            }
        }

        return true;
    }
}
