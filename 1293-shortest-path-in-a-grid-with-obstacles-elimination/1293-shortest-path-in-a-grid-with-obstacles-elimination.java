class Solution {
    
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        
        if(k>=m+n-2){
            return m+n-2;
        }
        
        Queue<StepState> dq = new LinkedList();
        HashSet<StepState> seen = new HashSet();
        StepState start = new StepState(0,0,k,0);
        dq.add(start);
        seen.add(start);
        
        while(!dq.isEmpty()){
            StepState curr = dq.poll();
            if(curr.r==m-1 && curr.c==n-1){
                return curr.steps;
            }
            
            int[] dirs = new int[]{0,1,0,-1,1,0,-1,0};
            
            for(int i=0;i<dirs.length;i=i+2){
                int newrow = curr.r+dirs[i];
                int newcol = curr.c+dirs[i+1];
            
            //check boundaries
                if(newrow<0 || newrow>=m || newcol<0 || newcol>=n){
                    continue;
                }
                int nextElimination = curr.k-grid[newrow][newcol];
                StepState newstate = new StepState(newrow, newcol, nextElimination, curr.steps+1);
                
                //add next move to queue
                if(nextElimination>=0 && !seen.contains(newstate)){
                    seen.add(newstate);
                    dq.add(newstate);
                }
            }
        }
        return -1;
    }
    
    
    class StepState{
        int r, c, k, steps;
        
        
        public StepState(int r, int c, int k, int steps){
            this.r=r;
            this.c=c;
            this.k=k;
            this.steps=steps;
        }
        @Override
        public boolean equals(Object other) {
            /**
             * only (row, col, k) matters as the state info
             */
            if (!(other instanceof StepState)) {
                return false;
            }
            StepState newState = (StepState) other;
            return (this.r == newState.r) && (this.c == newState.c) && (this.k == newState.k);
        }
        
        @Override
        public int hashCode() {
            // needed when we put objects into any container class
            return (this.r + 1) * (this.c + 1) * this.k;
        }
    }
}