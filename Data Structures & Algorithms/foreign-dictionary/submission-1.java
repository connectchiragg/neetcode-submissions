class Solution {
    List<Integer> cycle = new ArrayList<>();
    List<Integer> complete = new ArrayList<>();

    public String foreignDictionary(String[] words) {
        List<Integer>[] graph = new List[26];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.length - 1; i++){
            String left = words[i], right = words[i + 1];
            boolean substring = true;
            for(int j = 0; j < Math.min(left.length(), right.length()); j++){
                char l = left.charAt(j), r = right.charAt(j);

                if(l == r) continue;

                substring = false;

                if(graph[r - 'a'] == null){
                    graph[r - 'a'] = new ArrayList<>();
                }
                graph[right.charAt(j) - 'a'].add(left.charAt(j) - 'a');
                break;
            }

            if(substring && left.length() > right.length()) return "";
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                if(!dfs(result, graph, word.charAt(j) - 'a')){
                    return "";
                }
            }
        }

        return result.toString();
    }

    private boolean dfs(StringBuilder result, List<Integer>[] graph, int x){
        if(graph[x] == null){
            result.append((char)('a' + x));
            graph[x] = complete;
            return true;
        }
        if(graph[x] == cycle){
            // cycle detected
            return false;
        }

        if(graph[x] == complete){
            // already appended to result
            return true;
        }

        List<Integer> list = graph[x];
        graph[x] = cycle;

        for(int i : list){
            if(!dfs(result, graph, i)){
                return false;
            }
        }

        result.append((char)('a' + x));
        graph[x] = complete;

        return true;
    }
}
