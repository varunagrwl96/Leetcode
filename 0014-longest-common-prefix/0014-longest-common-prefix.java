class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return "";
        int n =strs.length;
        if(n==0) return "";
        String prefix=strs[0];
        for(int i=1;i<n;i++){
            int x=0,y=0;
            String curr = strs[i];
            while(x<prefix.length() && y<curr.length()){
                if(prefix.charAt(x)==curr.charAt(y)){
                    x++;
                    y++;
                }else{
                    break;
                }
            }
            prefix = prefix.substring(0,Math.min(x,y));
        }
        return prefix;
    }
}