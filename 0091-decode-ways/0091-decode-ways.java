// public class Solution {
//     public int numDecodings(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         int n = s.length();
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = s.charAt(0) != '0' ? 1 : 0;
//         for (int i = 2; i <= n; i++) {
//             int first = Integer.valueOf(s.substring(i - 1, i));
//             int second = Integer.valueOf(s.substring(i - 2, i));
//             if (first >= 1 && first <= 9) {
//                dp[i] += dp[i-1];  
//             }
//             if (second >= 10 && second <= 26) {
//                 dp[i] += dp[i-2];
//             }
//         }
//         return dp[n];
//     }
// }
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