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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        for(int i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i + 1).start < intervals.get(i).end){
                return false;
            }
        }

        return true;
    }
}
