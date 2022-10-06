class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return recursivePow(x,n);
    }
    
    public double recursivePow(double x, int N){
        if(N==0) return 1; //base
        if(N%2==0){
            return recursivePow(x*x,N/2);
        }else{
            return x*recursivePow(x*x,N/2);
        }
    }
}
//Optimize