class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        int ans=0;
        HashMap<Character,Integer> hashmap = new HashMap();
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);
        int prev=0;
        for(int i=0;i<n;i++){
            int curr = hashmap.get(s.charAt(i));
            if(curr>prev){
                curr=curr-prev;
                ans=ans-prev;
            }
            ans=ans+curr;
            prev=curr;
        }
        return ans;
    }
}