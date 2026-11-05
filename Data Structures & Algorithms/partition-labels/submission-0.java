/*

split a string


but the condtion is a letter should come in only one split

and we have to maximize the length of the split string

so we need on index

so we start at
x



x = 0
y = 1



left = 0 1 2

curr = 1


so if we find if we have already visited then we reduce to 1

but what if we find

x = 0 y = 2

ans = 3
xxyycy
we find  c ans = 3
then we find y
we should reset to 2 not 1

so we can store at x how much was the count


then we replace it with curr with that

but
xxxyycyc

x = 1 ->ans = 1
y = 2  -> ans = 2
c = 3. -> ans = 3


then
y -> ans = 2

curr > last -> keep last

curr < last -> keep present


how should I change all the elements between that

or should I say until this index how many


we find y

how to store the length and finalise that we will not see  them anymore

BF would be try for each char

i search x

then I find first and last
x = 0, 3
y = 1, 4
z = 5, 7
b = 6, 9


looks like a range problem we nee to find th range

then merge the range and then return for each range right. - left + 1


*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] entry = new int[26];
        int[] exit = new int[26];

        Arrays.fill(entry, -1);
        Arrays.fill(exit, -1);

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (entry[curr] == -1) {
                entry[curr] = i;
                exit[curr] = i;
            } else {
                exit[curr] = i;
            }
        }

        List<List<Integer>> range = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (entry[i] != -1) {
                range.add(new ArrayList<>(List.of(entry[i], exit[i])));
            }
        }

        List<List<Integer>> merged = new ArrayList<>();

        range.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<Integer> prev = range.get(0);
        for (int i = 1; i < range.size(); i++) {
             List<Integer>  curr = range.get(i);

            if (prev.get(1) < curr.get(0)) {
                merged.add(prev);
                prev = curr;
            } else {
                prev.set(1, Math.max(curr.get(1), prev.get(1)));
            }
        }

        merged.add(prev);

        System.out.println(merged);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < merged.size(); i++) {
            int left = merged.get(i).get(0);
            int right = merged.get(i).get(1);

            ans.add(right - left + 1);
        }

        return ans;
    }
}
