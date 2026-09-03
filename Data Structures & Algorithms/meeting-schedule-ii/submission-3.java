/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    record Event(int time, boolean isStart){}

    public int minMeetingRooms(List<Interval> intervals) {
        List<Event> events = new ArrayList<>(intervals.size() * 2);
        int curr = 0, result = 0;

        for(Interval interval : intervals){
            events.add(new Event(interval.start, true));
            events.add(new Event(interval.end, false));
        }

        events.sort((e1, e2) -> {
            if(e1.time() != e2.time()){
                return Integer.compare(e1.time(), e2.time());
            } else {
                return Integer.compare(e1.isStart() ? 1 : 0, e2.isStart() ? 1 : 0);
            }
        });

        for(Event event : events){
            curr += (event.isStart ? 1 : -1);
            result = Math.max(result, curr);
        }

        return result;
    }
}
