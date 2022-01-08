class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                return false;
            }
            node=node.get(c);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        // boolean found=false;
        for(char c : prefix.toCharArray()){
            if(node.containsKey(c)){
                // found=true;
                node = node.get(c);
            }else{
                return false;
            }
        }
        return true;
    }
}

class TrieNode{
    private TrieNode[] links;
    boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    
    public TrieNode get(char c){
        return links[c-'a'];
    }
    
    public void put(char c, TrieNode node){
        links[c-'a']=node;
    }
    
    public void setEnd(){
        isEnd=true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */