class Solution {
    public String longestPalindrome(String s) {
        int i=0;
        int maxlen=0;
        int maxi=0;
        int maxj=0;
        int n=s.length();
        while(i<n){
            int len1 = longestPalindrome(s,i,i);
            int len2 = longestPalindrome(s,i,i+1);
            if(len1>maxlen){
                maxlen=len1;
                maxi=i-((len1-1)/2);
                maxj=i+(len1/2);
            }
            // System.out.println(i+" "+maxi+" "+maxj);
            if(len2>maxlen){
                maxlen=len2;
                maxi=i-((len2-1)/2);
                maxj=i+(len2/2);
            }
            // System.out.println(i+" "+maxi+" "+maxj);
            i++;
        }
        return s.substring(maxi,maxj+1);
    }
    
    
    public int longestPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;//Imp
    }
}