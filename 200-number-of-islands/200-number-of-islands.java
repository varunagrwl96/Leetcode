class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        int m=grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void dfs(char[][] grid, int i, int j,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1' ||visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
}

//Time -> O(m*n)
// Space -> O(m*n) visited array