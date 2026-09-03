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
        int curr = 0, result = 0, n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;

        while(i < n && j < n){
            if(ends[j] <= starts[i]){
                curr--;
                j++;
            } else {
                curr++;
                i++;
            }

            result = Math.max(result, curr);
        }

        return result;
    }
}
