class TimeMap {
    Map<String, List<Entry>> map;

    public static class Entry{
        String value;
        int timestamp;

        Entry(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        int l = 0;
        List<Entry> list = map.get(key);
        int r = list.size() - 1;
        String result = "";

        while(l <= r){
            int mid = l + (r - l) / 2;
            Entry current = list.get(mid);
            if(timestamp < current.timestamp){
                
                r = mid - 1;
            } else {
                result = current.value;
                l = mid + 1;
            }
        }

        return result;
    }
}
