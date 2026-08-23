class Solution {
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> complete = new HashSet<>();

    public String foreignDictionary(String[] words) {
        Set<Integer>[] graph = new Set[26];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.length - 1; i++){
            String left = words[i], right = words[i + 1];
            boolean substring = true;
            for(int j = 0; j < Math.min(left.length(), right.length()); j++){
                char l = left.charAt(j), r = right.charAt(j);

                if(l == r) continue;

                substring = false;

                if(graph[r - 'a'] == null){
                    graph[r - 'a'] = new HashSet<>();
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

    private boolean dfs(StringBuilder result, Set<Integer>[] graph, int x){
        if(graph[x] == null){
            // orphans to be added immediately
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

        Set<Integer> list = graph[x];
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
