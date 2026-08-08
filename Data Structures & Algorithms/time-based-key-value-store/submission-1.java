class TimeMap {

    class Event {
        String value;
        int timestamp;

        public Event(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue(){
            return this.value;
        }

        public int getTime(){
            return this.timestamp;
        }
    }

    Map<String, List<Event>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Event(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(map.containsKey(key)){
            List<Event> events = map.get(key);
            result = search(events, timestamp);
        }

        return result;
    }

    private String search(List<Event> events, int t){
        int curr = -1, n = events.size();

        for(int i = n; i > 0; i /= 2){
            while(curr + i < n && events.get(curr + i).getTime() <= t){
                curr += i;
            }
        }

        return curr == -1 ? "" : events.get(curr).getValue();
    }
}
