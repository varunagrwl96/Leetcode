class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n = p.length();
        return recursion(0,0,s,p);
    }
    
    
    public boolean recursion(int i, int j, String s, String p){
        
        if(i>=s.length() && j>=p.length()) return true;
        if(j>=p.length()) return false;
        
        // if(i>=s.length() && j<p.length())//Need to check for * after
        
        boolean match = false;
        
        if(i<s.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
            match=true;
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            return recursion(i,j+2,s,p) || (match && recursion(i+1,j,s,p));
        }
        if(match){
            i++;
            j++;
            return recursion(i,j,s,p);
        }
        return false;
    }
}