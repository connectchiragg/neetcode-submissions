class TrieNode {
    TrieNode[] children;
    String word;
    int childCount;

    public TrieNode(){
        children = new TrieNode[26];
        childCount = 0;
    }
}


class Solution {
    private static final int[][] DIRS = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode temp = root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(temp.children[c - 'a'] == null){
                    temp.childCount++;
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }

            temp.word = word;
        }

        search(result, board, root);
        return result;
    }

    private void search(List<String> result, char[][] board, TrieNode root){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                TrieNode child = root.children[board[i][j] - 'a'];
                dfs(result, board, child, i, j);
                if(child != null && child.word == null && child.childCount == 0){
                    root.childCount--;
                    root.children[board[i][j] - 'a'] = null;
                }
            }
        }
    }

    private void dfs(List<String> result, char[][] board, TrieNode root, int i, int j){
        if(root == null){
            return;
        }


        // Preserving the value & blocking it from reuse
        char c = board[i][j];
        board[i][j] = '.';

        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }

        for(int[] dir : DIRS){
            int i1 = i + dir[0], j1 = j + dir[1];

            if(i1 < 0 || j1 < 0 || i1 == board.length ||
               j1 == board[0].length || board[i1][j1] == '.') 
                continue;

            TrieNode child = root.children[board[i1][j1] - 'a'];

            dfs(result, board, child, i1, j1);

            if(child != null && child.word == null && child.childCount == 0){
                root.childCount--;
                root.children[board[i1][j1] - 'a'] = null;
            }
        }

        // reverting the char
        board[i][j] = c;
    }











}