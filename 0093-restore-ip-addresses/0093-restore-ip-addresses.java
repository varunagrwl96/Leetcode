class Solution {
    
    List<String> ans = new ArrayList();
    LinkedList<String> segments = new LinkedList<String>();
    int n;
    String s;
    
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        this.s=s;
        backtrack(-1,3);
        return ans;
    }
    
    public void backtrack(int prev_pos, int dots){
        int max_pos = Math.min(n-1,prev_pos+4);
        for(int i=prev_pos+1;i<max_pos;i++){
            String segment = s.substring(prev_pos+1,i+1);
            if(valid(segment)){
                segments.add(segment);
                if(dots-1==0){
                    update_ans(i);
                }
                else{
                    backtrack(i,dots-1);
                }
                segments.removeLast();
            }
        }
    }
    
    public boolean valid(String segment) {
    /*
    Check if the current segment is valid :
    1. less or equal to 255      
    2. the first character could be '0' 
    only if the segment is equal to '0'
    */
    int m = segment.length();
    if (m > 3)
      return false;
    return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
  }
    
  public void update_ans(int curr_pos) {
    /*
    Append the current list of segments 
    to the list of solutions
    */
    String segment = s.substring(curr_pos + 1, n);
    if (valid(segment)) {
      segments.add(segment);
      ans.add(String.join(".", segments));
      segments.removeLast();
    }
  }
}