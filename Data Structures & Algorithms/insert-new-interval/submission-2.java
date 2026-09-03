class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i++]);
        }

        while(i < intervals.length && isOverlap(intervals[i], newInterval)){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        list.add(newInterval);

        while(i < intervals.length){
            list.add(intervals[i++]);
        }

        return list.toArray(new int[list.size()][]);
    }

    private boolean isOverlap(int[] first, int[] second){
        if(first[1] < second[0] || first[0] > second[1]) return false;
        return true;
    }
}
