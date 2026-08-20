class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        List<Integer>[] nums = new List[list.size()];
        Queue<Integer> q = new ArrayDeque<>();
        Map<String, List<Integer>> patterns = new HashMap<>();
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = new ArrayList<>();
        }

        for(int i = 0; i < list.size(); i++){
            String word = list.get(i);
            for(int j = 0; j < word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                patterns.computeIfAbsent(pattern, l -> new ArrayList<>()).add(i);
            }
        }

        for(int i = 0; i < list.size(); i++){
            String word = list.get(i);
            for(int j = 0; j < word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                for(int k : patterns.get(pattern)){
                    if(k != i) nums[i].add(k);
                }
            }
        }

        for(int j = 0; j < start.length(); j++){
            String pattern = start.substring(0, j) + "*" + start.substring(j + 1);

            if(!patterns.containsKey(pattern)) continue;

            for(int k : patterns.get(pattern)){
                q.add(k);
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
}
