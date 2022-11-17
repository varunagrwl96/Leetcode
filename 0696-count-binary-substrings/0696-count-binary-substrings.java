class Solution {
    
    public int countBinarySubstrings(String s) {
        int prevrunlength = 0;
        int currunlength=1;
        int ans=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                currunlength++;
            }else{
                prevrunlength=currunlength;
                currunlength=1;
            }
            if(prevrunlength>=currunlength) ans++;
        }
        return ans;
    }
}