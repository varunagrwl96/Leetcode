class Solution {
    public int reverse(int x) {
        int ans=0;
        int max = Integer.MAX_VALUE;
        boolean isNegative=false;
        if(x<0){
            isNegative=true;
            x=x*-1;
        }
        while(x>0){
            int curr = x%10;
            if(ans>max/10 || (ans == max/10 && curr>7)){
                return 0;
            }else{
                ans = ans*10 + curr;
            }
            x=x/10;
        }
        if(isNegative){
            ans=ans*-1;
        }
        return ans;
    }
}