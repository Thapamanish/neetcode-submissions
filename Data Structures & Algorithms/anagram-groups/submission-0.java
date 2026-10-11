class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedStrings = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newString = String.valueOf(charArray);

            sortedStrings.computeIfAbsent(newString, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(sortedStrings.values());
    }
}
