/*

we have alien dictionary

and we have to return the lexocgraphically increasing string by looking the given list of word

we can find character lexogrphavically by seeing the first leve

and withinsame first char we have to find the second
and return "" if the given input is invalid and not follwoing the rule




*/

class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
                indeg.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i + 1 < words.length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word2.length() < word1.length() && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(word2.length(), word1.length());

            for (int j = 0; j < len; j++) {
                char first = word1.charAt(j);
                char second = word2.charAt(j);

                if (first != second) {
                    if (adj.get(first).add(second)) {
                        indeg.put(second, indeg.get(second) + 1);
                    }
                    break;
                }
            }
        }

        ArrayDeque<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indeg.entrySet()) {
            if (entry.getValue() == 0)
                q.offer(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char curr = q.pop();
            sb.append(curr);
            for (Character neighbor : adj.get(curr)) {
                indeg.put(neighbor, indeg.get(neighbor) - 1);
                if (indeg.get(neighbor) == 0)
                    q.offer(neighbor);
            }
        }

        return sb.length() == indeg.size() ? sb.toString() : "";
    }
}

