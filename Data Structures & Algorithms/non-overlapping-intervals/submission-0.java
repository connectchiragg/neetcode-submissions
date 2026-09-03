class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i + 1][1] > intervals[i][0] && intervals[i + 1][0] < intervals[i][1]){
                if(intervals[i + 1][1] > intervals[i][1]){
                    intervals[i + 1] = intervals[i];
                }
                result++;
            }
        }

        return result;
    }
}