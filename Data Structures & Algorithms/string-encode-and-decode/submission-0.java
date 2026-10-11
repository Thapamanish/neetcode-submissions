class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;

        List<String> decodedList = new ArrayList<>();

        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + len;

            decodedList.add(str.substring(start, end));

            i = end;
        }

        return decodedList;
    }
}
