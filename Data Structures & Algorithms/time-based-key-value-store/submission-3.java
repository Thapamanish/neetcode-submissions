/*
So we need to make a map

where we will store key value and time


storing key and multiple values is pretty easy

we can make map(string, List<String>)

but the catch is we need to return the as per the time stamp

if if there is a timestamp 4 and we need exactly 4 then well and good we can get it

we can do Map<String, Map<String, String>>

we need to return anthing which is smaller than the current timestamp,

I am thinking for a binary search to find the just smaller

since we will add the timestamp in increasing order then it is a good way to do it


we make map of map <String, List<String>>

or we don't query by value we query by key and timestamp so map<String, List<List<String>> would
work

TC - O(n * logn)

SC - O(n)

*/
class TimeMap {
    Map<String, List<List<String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(List.of(value, String.valueOf(timestamp)));
    }

    public String get(String key, int timestamp) {
        List<List<String>> value = timeMap.get(key);

        if (value == null)
            return "";

        int left = 0, right = value.size() - 1;

        if (timestamp < Integer.parseInt(value.get(0).get(1)))
            return "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            List<String> curr = value.get(mid);
            if (Integer.parseInt(curr.get(1)) == timestamp)
                return curr.get(0);
            else if (Integer.parseInt(curr.get(1)) < timestamp)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return value.get(right).get(0);
    }
}
