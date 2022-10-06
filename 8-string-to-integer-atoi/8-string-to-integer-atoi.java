class Solution {
    public int myAtoi(String s) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int i=0;
        int ans=0;
        int sign=1;
        int length = s.length();
        while(i<length && s.charAt(i)==' '){
                i++;
        }
        if(i==length) return 0;
        
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        
        while(i<length){
            int digit = s.charAt(i) - '0';
            if(digit<0 || digit>9){
                break;
            }
            
            if(max/10 < ans || (max/10 == ans && max %10 < digit)){
                return sign==1 ? max : min;
            }
            ans = ans*10 + digit;
            i++;
        }
        return sign*ans;
    }
}
//O(n)
//O(1)