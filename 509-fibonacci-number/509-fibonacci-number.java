class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int fprevprev=0;
        int fprev=1;
        int fcurr=1;
        for(int i=2;i<=n;i++){
            fcurr = fprev + fprevprev;
            fprevprev=fprev;
            fprev=fcurr;
        }
        return fcurr;
    }
}