class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
    }
}


class Solution {
    int[][] DIRS = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        // List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode temp = root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(temp.children[c - 'a'] == null){
                    temp.children[c - 'a'] = new TrieNode();
                }

                temp = temp.children[c - 'a'];
            }

            temp.isWord = true;
        }

        search(result, board, root);
        return new ArrayList<>(result);
    }

    private void search(Set<String> result, char[][] board, TrieNode root){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                dfs(result, board, root.children[c - 'a'], i, j, new StringBuilder());
            }
        }
    }

    private void dfs(Set<String> result, char[][] board, TrieNode root, int i, int j, StringBuilder sb){
        if(root == null){
            return;
        }


        // Preserving the value, adding this char & blocking it from reuse
        char c = board[i][j];
        sb.append(c);
        board[i][j] = '.';

        if(root.isWord){
            result.add(sb.toString());
        }

        for(int[] dir : DIRS){
            int i1 = i + dir[0], j1 = j + dir[1];

            if(i1 < 0 || j1 < 0 || i1 == board.length || j1 == board[0].length || board[i1][j1] == '.') continue;

            dfs(result, board, root.children[board[i1][j1] - 'a'], i1, j1, sb);
        }

        // reverting the char and its usage
        sb.setLength(sb.length() - 1);
        board[i][j] = c;
    }











}