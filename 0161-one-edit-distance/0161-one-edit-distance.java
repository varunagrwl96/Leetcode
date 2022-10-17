class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        int i=0,j=0;
        while(i<ns && j<nt && s.charAt(i) == t.charAt(j)){
            i++;
            j++;
        }
        if(i==ns && j==nt){
            return false;
        }
        if(ns==1 && nt==1) return true;
        if(ns>nt){
            return s.substring(i+1).equals(t.substring(j));
        }else if(nt>ns){
            return s.substring(i).equals(t.substring(j+1));
        }else{
            return s.substring(i+1).equals(t.substring(j+1));
        }
    }
}