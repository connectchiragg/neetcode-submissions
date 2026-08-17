class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;

        for(int i = 0; i < word.length(); i++){
            if(temp.children[word.charAt(i) - 'a'] == null){
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }

        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;

        for(int i = 0; i < word.length(); i++){
            if(temp.children[word.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }

        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for(int i = 0; i < prefix.length(); i++){
            if(temp.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.children[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}
