class Solution {
    public int reverse(int x) {
        int ans=0;
        boolean isneg=false;
        if(x<0){
            x=-x;
            isneg=true;
        }
        while(x>0){
            int last = x%10;
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && last>Integer.MAX_VALUE%10)){
                return 0;
            }
            ans = ans*10+last;
            x=x/10;
        }
        return isneg?-1*ans:ans;
    }
}