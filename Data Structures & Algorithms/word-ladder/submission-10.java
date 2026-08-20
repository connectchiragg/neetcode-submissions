class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        Queue<Integer> q = new ArrayDeque<>();
        Map<String, List<Integer>> patterns = new HashMap<>();
        int result = 0;

        for(int i = 0; i < list.size(); i++){
            String word = list.get(i);
            for(int j = 0; j < word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                patterns.computeIfAbsent(pattern, l -> new ArrayList<>()).add(i);
            }
        }

        for(int j = 0; j < start.length(); j++){
            String pattern = start.substring(0, j) + "*" + start.substring(j + 1);

            List<Integer> neighbors = patterns.get(pattern);

            if(neighbors == null) continue;

            for(int k : neighbors){
                q.add(k);
            }

            patterns.remove(pattern);
        }


        while(!q.isEmpty()){
            int size = q.size();
            result++;

            while(size-- > 0){
                int curr = q.poll();

                String word = list.get(curr);

                if(word.equals(end)){
                    return ++result;
                }

                for(int j = 0; j < word.length(); j++){
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    List<Integer> neighbors = patterns.get(pattern);

                    if(neighbors == null) continue;

                    for(int k : neighbors){
                        q.add(k);
                    }

                    patterns.remove(pattern);
                }
            }
        }

        return 0;
    }
}
