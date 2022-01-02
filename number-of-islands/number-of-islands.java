class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]!='0'){
                    count+=countIsland(grid,i,j,rows,cols);
                }
            }
        }
        return count;
    }
    
    public int countIsland(char[][] grid, int i, int j, int rows, int cols){
        char curr = grid[i][j];
        visited[i][j]=true;
        if(curr=='1'){
            if(i+1< rows && !visited[i+1][j]){
                countIsland(grid,i+1,j,rows,cols);
            }
            if(j+1< cols && !visited[i][j+1]){
                countIsland(grid,i,j+1,rows,cols);
            }
            if(i-1>=0 && !visited[i-1][j]){
                countIsland(grid,i-1,j,rows,cols);
            }
            if(j-1>=0 && !visited[i][j-1]){
                countIsland(grid,i,j-1,rows,cols);
            }
            return 1;
        }else{
            return 0;
        }
    }
}

//  1 1 1
//  0 1 0
//  1 1 1