class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hashmap = new HashMap();
        for(String cpdomain : cpdomains){
            String[] space_split = cpdomain.split(" ");
            int number = Integer.parseInt(space_split[0]);
            String addr = space_split[1];
            String[] split = addr.split("\\.");
            int n=split.length;
            String curr="";
            for(int i=n-1;i>=0;i--){
                // String curr = split[i];
                curr = split[i] +(i==n-1? "" : ".")+ curr;
                if(hashmap.containsKey(curr)){
                    hashmap.put(curr,hashmap.get(curr)+number);
                }else{
                    hashmap.put(curr,number);
                }
            }
        }
        List<String> ans = new ArrayList();
        for(String key : hashmap.keySet()){
            ans.add(hashmap.get(key) +" "+ key);
        }
        return ans;
    }
}