class Solution {
    List<String> ans = new ArrayList();
    String s=null;
    int n;
    LinkedList<String> segments = new LinkedList();
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        n=s.length();
        backtrack(-1,3);
        return ans;
    }
    
    public void backtrack(int prevpos, int dots){
        int max_pos = Math.min(prevpos+4,n-1); 
        for(int i=prevpos+1;i<max_pos;i++){
            String segment = s.substring(prevpos+1,i+1);
            if(isValid(segment)){
                segments.add(segment);
                if(dots-1==0){
                    update_ans(i);
                }else{
                    backtrack(i,dots-1);
                }
                segments.removeLast();
            }
        }
    }
    
    public boolean isValid(String curr){
        if(curr.length()>3){
            return false;
        }
        return curr.charAt(0)=='0'? curr.length()==1 : Integer.valueOf(curr)<=255;
    }
    
    public void update_ans(int curr_pos){
        String segment = s.substring(curr_pos+1,n);
        if(isValid(segment)){
            segments.add(segment);
            ans.add(String.join(".",segments));
            segments.removeLast();
        }
    }
    
}