class Solution {
    HashMap<String,Integer> memo = new HashMap();
    public int numDecodings(String s) {
        return helper(s,0);
    }
    
    public int helper(String s, int index){
        if(memo.containsKey(s.substring(index))){
            return memo.get(s.substring(index));
        }
        if(index==s.length()){
            return 1;
        }
        
        if(s.charAt(index)=='0'){
            return 0;
        }
        
        if(index==s.length()-1){
            return 1;
        }
        
        int ans = helper(s,index+1);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
            ans+=helper(s,index+2);
        }
        memo.put(s.substring(index),ans);
        return ans;
    }
}