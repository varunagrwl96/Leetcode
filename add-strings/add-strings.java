class Solution {
    public String addStrings(String num1, String num2) {
        int n=num1.length()-1;
        int m =num2.length()-1;
        int carry=0;
        StringBuilder ans=new StringBuilder();
        while(n>=0 || m>=0){
            int one = (n>=0) ? num1.charAt(n)-'0' : 0;
            int two = (m>=0) ? num2.charAt(m)-'0' : 0;
            int sum = one+two+carry;
            carry=0;
            if(sum>=9){
                carry=sum/10;
            }
            sum=sum%10;
            ans.append(sum);
            n--;
            m--;
        }
        if(carry>0){
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}