class Solution {
    public boolean rotateString(String s, String goal) {
        if(s==null || goal==null) return false;
        if(s.length()!=goal.length()) return false;
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        int counter=0;
        while(counter<n){
            if(s.equals(goal)){
                 return true;
            }else{
                sb.insert(n,s.charAt(0));
                sb.replace(0,1,"");
                s=sb.toString().substring(0,n);
                // System.out.println(s);
            }
            counter++;
        }
        return false;
    }
}