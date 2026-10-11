/*
we need to group string in the array which have equal and same number of characters


use map to store the groups with key sorted string so that I can search each current string by sorting it in the map and if yes put in the map 

at last return the values.


TC -> O(n * dlogd) - > n traversal and d is length of the longest string

SC -> O(n) longest hashmap



*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sortedStr = String.valueOf(ch);

            groups.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
