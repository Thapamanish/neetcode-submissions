class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newStr = String.valueOf(charArray);

            if(!anagrams.containsKey(newStr)){
                anagrams.put(newStr, new ArrayList<>());
            }
                anagrams.get(newStr).add(str);
        }



        return new ArrayList<>(anagrams.values());
    }
}
