class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        List<Integer>[] nums = new List[list.size()];
        Queue<Integer> q = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = new ArrayList<>();
        }

        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(isJoined(list.get(i), list.get(j))){
                    nums[i].add(j);
                    nums[j].add(i);
                }
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(isJoined(start, list.get(i))){
                q.add(i);
            }
        }


        while(!q.isEmpty()){
            int size = q.size();
            result++;

            while(size-- > 0){
                int curr = q.poll();

                if(list.get(curr).equals(end)){
                    return ++result;
                }

                for(int i : nums[curr]){
                    q.add(i);
                }

                nums[curr] = new ArrayList<>();
            }
        }

        return 0;
    }

    private boolean isJoined(String a, String b){
        int count = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count > 1) return false;
            }
        }

        return count == 1;
    }
}
