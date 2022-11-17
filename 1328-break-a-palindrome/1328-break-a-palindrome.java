class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1) return "";
        String ans="";
        for(int i=0;i<n/2;i++){
            char curr = palindrome.charAt(i);
            if(curr=='a'){
                continue;
            }else{
                // System.out.println()
                ans=palindrome.substring(0,i)+"a"+palindrome.substring(i+1);
                return ans;
            }
        }
        return palindrome.substring(0,n-1)+"b";
    }
}