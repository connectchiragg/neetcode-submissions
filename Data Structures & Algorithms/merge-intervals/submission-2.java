class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int i = 0;

        while(i < intervals.length){
            if(i + 1 < intervals.length && intervals[i + 1][0] > intervals[i][1]){
                result.add(intervals[i++]);
                continue;
            }

            int[] curr = intervals[i];

            while(i + 1 < intervals.length && intervals[i + 1][1] >= curr[0] && intervals[i + 1][0] <= curr[1]){
                curr[0] = Math.min(curr[0], intervals[i + 1][0]);
                curr[1] = Math.max(curr[1], intervals[i + 1][1]);
                i++;
            }
            i++;

            result.add(curr);
        }

        if(i < intervals.length){
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
