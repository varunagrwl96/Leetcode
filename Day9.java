/* Solution O(N) time and O(1) Space Back traversal*/
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
---------------------------------------------------------------
/*Straight traversing the input with O(1) space and O(N) time */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return computeString(S).compareTo(computeString(T))==0;
    }
    
    public String computeString(String S){
        String ans="";
        int slength = S.length();
        int word=0;
        for(int i=0;i<slength;i++){
            if(S.charAt(i)!='#'){
                word++;
                ans+=S.charAt(i);
            }else{
                if(word>0){
                    ans = ans.substring(0,word-1);
                    word--;
                }else if(word==0){
                    ans="";
                }
            }
        }
        return ans;
    }
}