class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null){
                temp.children[idx] = new TrieNode();
            }
            temp = temp.children[idx];
        }

        temp.isWord = true;
    }

    public boolean search(String word) {
        return searchPattern(root, word, 0);
    }

    private boolean searchPattern(TrieNode temp, String word, int start){
        if(start == word.length()){
            return temp != null && temp.isWord;
        }

        if(temp == null) return false;

        for(int i = start; i < word.length(); i++){
            char c = word.charAt(i);

            if(c == '.'){
                for(int j = 0; j < 26; j++){
                    if(searchPattern(temp.children[j], word, i + 1)){
                        return true;
                    }
                }
                return false;
            } else {
                if(temp.children[c - 'a'] == null){
                    return false;
                }
                temp = temp.children[c - 'a'];
            }
        }

        return temp.isWord;
    }
}
