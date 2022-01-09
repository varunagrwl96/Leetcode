class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node=node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return search2(word,root);
    }
    
    public boolean search2(String word, TrieNode neighbour){
        TrieNode node = neighbour;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode neighbour2 : node.links){
                    if(neighbour2!=null){
                        boolean found = search2(word.substring(i+1), neighbour2);
                        if(found){
                            return true;
                        }
                    }
                }
            return false;
        }else if(node.containsKey(c)){
                node = node.get(c);
        }else{
                return false;
            }
        }
        return node.isEnd();
    }
}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
    }
    
    public void put(char c, TrieNode node){
        links[c-'a']=node;
    }
    
    public TrieNode get(char c){
        return links[c-'a'];
    }
    
    public boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
    
    public void setEnd(){
        isEnd=true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */