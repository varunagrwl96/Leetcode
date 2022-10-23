class Solution {
    public int shortestBridge(int[][] grid) {
        int m=grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        boolean foundoneisland=false;
        
        //DFS
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(foundoneisland){
                    break;
                }
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited, queue);
                    foundoneisland=true; //IMPORTANT CUZ U NEED ONLY ONE ISLAND IN QUEUE
                }
            }
        }
        
        //BFS on all 1's of one island
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int distance=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                for(int[] dir : dirs){
                    int newi = i+dir[0];
                    int newj = j+dir[1];
                    if(newi>=0 && newj>=0 && newi<m && newj<n && !visited[newi][newj]){
                        if(grid[newi][newj]==1){
                            return distance;
                        }
                        queue.add(new int[]{newi,newj});
                        visited[newi][newj]=true;
                    }
                }
                size--;
            }
            distance++;
        }
        return -1;
    }
    
    
    public void dfs(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> queue){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1 || visited[i][j]){
            return;
        }
        
        visited[i][j]=true;
        queue.add(new int[]{i,j});
        dfs(grid,i+1,j,visited,queue);
        dfs(grid,i-1,j,visited,queue);
        dfs(grid,i,j+1,visited,queue);
        dfs(grid,i,j-1,visited,queue);
    }
}