class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] courses = new List[n];

        for(int[] preq : prerequisites){
            if(courses[preq[0]] == null){
                courses[preq[0]] = new ArrayList<>();
            }
            courses[preq[0]].add(preq[1]);
        }

        for(int i = 0; i < n; i++){
            if(!isValid(courses, i)) return false;
        }

        return true;
    }

    private boolean isValid(List<Integer>[] courses, int i){
        if(courses[i] != null && courses[i].isEmpty()) return false;
        if(courses[i] == null) return true;

        List<Integer> preqs = courses[i];
        courses[i] = new ArrayList<>();

        for(int preq : preqs){
            if(!isValid(courses, preq)) return false;
        }

        courses[i] = null;

        return true;
    }
}