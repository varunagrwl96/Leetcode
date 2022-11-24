class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxarea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    maxarea = Math.max(maxarea,getArea(i,j,grid, visited));
                }
            }
        }
        return maxarea;
    }
    
    
    public int getArea(int i, int j, int[][] grid, boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j]||grid[i][j]!=1){
            return 0;
        }
        visited[i][j]=true;
        return 1+ getArea(i+1,j,grid,visited) +
                getArea(i-1,j,grid,visited) +
                getArea(i,j+1,grid,visited) +
                getArea(i,j-1,grid,visited);
        
        // return Math.max(a1,Math.max(a2,Math.max(a3,a4)));
    }
}