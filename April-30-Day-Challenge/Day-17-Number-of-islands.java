O(row*col) time & space complexity i.e. Linear time & space complexity
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count=0;
        boolean[][] visited = new boolean[row][col];
        List<Pair<Integer,Integer>> directions = new ArrayList();
        directions.add(new Pair(0,1));
        directions.add(new Pair(1,0));
        directions.add(new Pair(0,-1));
        directions.add(new Pair(-1,0));
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    ++count;
                    Queue<Pair> queue = new LinkedList();
                    queue.add(new Pair(i,j));
                    visited[i][j]=true;
                    while(!queue.isEmpty()){
                        Pair<Integer,Integer> pair = queue.remove();
                        for(Pair<Integer,Integer> dir : directions){
                            Integer neighbor_row = dir.getKey() + pair.getKey();
                            Integer neighbor_col = dir.getValue() + pair.getValue();
                        if(inboundary(row,col,neighbor_row,neighbor_col) && grid[neighbor_row][neighbor_col]=='1' && !visited[neighbor_row][neighbor_col]){
                            queue.add(new Pair(neighbor_row,neighbor_col));
                            visited[neighbor_row][neighbor_col]=true;
                        }
                    }
                    }
                }
            }
        }
        return count;
    }
    
    public boolean inboundary(int row,int col,Integer i,Integer j){
        return (i>=0 && i<row && j>=0 &&j<col);
    }
}