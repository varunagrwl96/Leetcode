class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans = new ArrayList();
        //build trie for each word
        TrieNode roothead = new TrieNode();
        for(String word : words){
            TrieNode root = roothead;
            for(char c : word.toCharArray()){
                if(root.children[c-'a']==null){
                    root.children[c-'a'] = new TrieNode();
                }
                root=root.children[c-'a'];
            }
            root.word=word;
        }
        //Traverse the board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int index = board[i][j] - 'a';
                if(roothead.children[index]!=null){
                    TrieNode p = roothead;
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    dfs(p,i,j,board,visited,ans);
                }else{
                    continue;
                }
            }
        }
        return ans;
    }
    
    public void dfs(TrieNode p, int i, int j, char[][] board, boolean[][] visited, List<String> ans){
        
        if(i<0||i>=board.length || j<0 || j>=board[0].length || visited[i][j]){
            return;
        }
        
        if(p.children[board[i][j]-'a']==null){
            return;
        }
        if(p.children[board[i][j]-'a'].word!=null){
            ans.add(p.children[board[i][j]-'a'].word);
            p.children[board[i][j]-'a'].word=null;
        }
        visited[i][j]=true;
        
        dfs(p.children[board[i][j]-'a'],i+1,j,board,visited,ans);
        dfs(p.children[board[i][j]-'a'],i-1,j,board,visited,ans);
        dfs(p.children[board[i][j]-'a'],i,j+1,board,visited,ans);
        dfs(p.children[board[i][j]-'a'],i,j-1,board,visited,ans);
        
        visited[i][j]=false;
    }
}


class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
    TrieNode(){}
}