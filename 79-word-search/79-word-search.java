class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        visited = new boolean[m][n];
        // for(int i=0;i<word.length()-1;i++){
            // char c = word.charAt(i);
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    // if(board[j][k]==c){
                        if(helper(board,word,j,k,0)){
                            return true;
                        }
                    }
                }
        return false;
    }
    
    
    public boolean helper(char[][] board, String word, int j, int k, int index){
        if(index==word.length()) return true;
        if(j>=board.length || k>=board[0].length || j<0 || k<0 || board[j][k]!=word.charAt(index)) return false;
        board[j][k]='!';
        boolean res = helper(board,word,j+1,k,index+1) | helper(board,word,j-1,k,index+1) | helper(board,word,j,k+1,index+1) | helper(board,word,j,k-1,index+1);
        board[j][k]=word.charAt(index);
        return res;
    }
}