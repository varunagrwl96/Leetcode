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
        TrieNode node = root;
        int i=0;
        for(char c : word.toCharArray()){
            if(c=='.'){
                for(TrieNode neighbour : node.links){
                    if(neighbour!=null){
                        boolean found = searchNeighbour(word.substring(i+1), neighbour);
                        if(found){
                            return true;
                        }
                    }
                }
                return false;
            }else if(node.containsKey(c)){
                node = node.get(c);
                i++;
            }else{
                return false;
            }
        }
        System.out.println(node.isEnd());
        return node.isEnd();
    }
    
    public boolean searchNeighbour(String word, TrieNode neighbour){
        TrieNode node = neighbour;
        int i=0;
        for(char c : word.toCharArray()){
            if(c=='.'){
                for(TrieNode neighbour2 : node.links){
                    if(neighbour2!=null){
                        boolean found = searchNeighbour(word.substring(i+1), neighbour2);
                        if(found){
                            return true;
                        }
                    }
                }
                return false;
            }else if(node.containsKey(c)){
                node = node.get(c);
                i++;
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