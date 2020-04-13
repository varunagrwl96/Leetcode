/* Solution O(N) time and O(1) Space */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).compareTo(getString(T))==0;
    }
    
    public String getString(String S){
        int slength=S.length();
        int backspace=0;
        String sAns="";
        for(int i=slength-1;i>=0;i--){
            if(S.charAt(i)=='#'){
                backspace++;
            }else if(backspace==0){
                sAns += S.charAt(i); 
            }else{
                backspace--;
            }
        }
        return sAns;
    }
}