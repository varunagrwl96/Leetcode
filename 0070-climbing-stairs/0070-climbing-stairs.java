class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] ways = new int[n+1];
        ways[0]=0;
        ways[1]=1;
        ways[2]=2;
        for(int i=3;i<=n;i++){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];
    }
}
// Time O(n)
// Space O(n)
    
    // public int climbStairs(int n) {
    //     return climb_Stairs(0, n);
    // }
    // public int climb_Stairs(int i, int n) {
    //     if (i > n) {
    //         return 0;
    //     }
    //     if (i == n) {
    //         return 1;
    //     }
    //     return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    // }
//Time O(2^N)
//Space O(n) recursion depth