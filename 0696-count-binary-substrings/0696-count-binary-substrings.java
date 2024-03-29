class Solution {
    
    public int countBinarySubstrings(String s) {
//                 int[] groups = new int[s.length()];
//         int t = 0;
//         groups[0] = 1;
//         for (int i = 1; i < s.length(); i++) {
//             if (s.charAt(i-1) == s.charAt(i)) {
//                 groups[t]++;
//             } else {
//                 groups[++t] = 1;
//             }
//         }

//         int ans = 0;
//         for (int i = 1; i <= t; i++) {
//             ans += Math.min(groups[i-1], groups[i]);
//         }
//         return ans;
        
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