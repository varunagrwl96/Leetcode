class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
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