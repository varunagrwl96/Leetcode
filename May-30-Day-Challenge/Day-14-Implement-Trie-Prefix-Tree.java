class Trie {

    /** Initialize your data structure here. */
    HashSet<String> hashset;
    
    public Trie() {
        hashset = new HashSet();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        hashset.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return hashset.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for(String s : hashset){
            if(s.startsWith(prefix)==true){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */