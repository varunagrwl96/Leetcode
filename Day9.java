class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).compareTo(getString(T))==0;
    }
    
    public String getString(String S){
        int slength=S.length();
        char[] sCharArray = S.toCharArray();
        int backspace=0;
        String sAns="";
        for(int i=slength-1;i>=0;i--){
            if(sCharArray[i]=='#'){
                backspace++;
            }else if(backspace==0){
                sAns += sCharArray[i]; 
            }else{
                backspace--;
            }
        }
        return sAns;
    }
}