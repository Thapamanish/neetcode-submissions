/*
I will use Map<string, List<Entry>>

and before giving out the value I will do binary search to return exact or the left smaller value
*/
class TimeMap {
    private static class Entry {
        private String value;
        private int timestamp;
        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Entry>> seen;
    public TimeMap() {
        seen = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        seen.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Entry> curr = seen.get(key);

        if (curr == null)
            return "";

        int left = 0;
        int right = curr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Entry currEntry = curr.get(mid);
            if (currEntry.timestamp == timestamp)
                return currEntry.value;
            else if (currEntry.timestamp > timestamp)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right == -1 ? "" : curr.get(right).value;
    }
}
