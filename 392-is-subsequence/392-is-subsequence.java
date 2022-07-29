class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i=0;
        for(int j=0;j<n && i<m;j++){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
        }
        if(i==m){
            return true;
        }else{
            return false;
        }
    }
}