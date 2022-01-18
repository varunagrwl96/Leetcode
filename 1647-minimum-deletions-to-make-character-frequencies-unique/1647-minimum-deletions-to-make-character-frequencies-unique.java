class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
	    for (char c : s.toCharArray())
		    freq[c - 'a']++;
	    Arrays.sort(freq);
        int prev=freq[25];
        int ans=0;
        for(int i=24;i>=0;i--){
            if(freq[i]!=0){
                if(prev==freq[i]){
                    ans++;
                    freq[i]--;
                }
                else if(prev<freq[i]){
                    ans=ans+freq[i]-prev;
                    if(prev!=0) ans++;
                    freq[i]=Math.max(0,prev-1);
                }
                prev=freq[i];
            }
        }
        return ans;
    }
}