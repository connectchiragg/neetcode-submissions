class Solution {
    record Course(int idx, boolean isValid) {}

    // This is a stored reference to be used to identify completed (not visited) nodes
    private static final List<Integer> FLAG = Collections.emptyList();

    public int[] findOrder(int n, int[][] prerequisites) {
        int[] result = new int[n];
        List<Integer>[] courses = new List[n];
        int idx = 0;

        for(int[] preq : prerequisites){
            if(courses[preq[0]] == null){
                courses[preq[0]] = new ArrayList<>();
            }

            courses[preq[0]].add(preq[1]);
        }

        for(int i = 0; i < n; i++){
            Course course = dfs(result, courses, i, idx);
            if(!course.isValid()) return new int[0];
            idx = course.idx();
        }

        return result;
    }

    private Course dfs(int[] result, List<Integer>[] courses, int i, int idx){
        if(courses[i] == null){
            result[idx++] = i;
            courses[i] = FLAG;
            return new Course(idx, true);
        }

        if(courses[i] == FLAG) return new Course(idx, true);
        if(courses[i].isEmpty()) return new Course(idx, false);

        List<Integer> preqs = courses[i];
        courses[i] = new ArrayList<>();

        for(int preq : preqs){
            Course course = dfs(result, courses, preq, idx);
            if(!course.isValid()) return course;
            idx = course.idx();
        }

        result[idx++] = i;
        courses[i] = FLAG;

        return new Course(idx, true);
    }
}
