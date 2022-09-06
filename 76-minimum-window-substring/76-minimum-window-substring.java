class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hashmap = new HashMap();
        for(char c : t.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        int begin=0;
        int end=0;
        int counter=hashmap.size();
        int len=Integer.MAX_VALUE;
        int head=0;
        
        while(end<s.length()){
            char c = s.charAt(end);
            if(hashmap.containsKey(c)){
                hashmap.put(c,hashmap.get(c)-1);
                if(hashmap.get(c)==0){
                    counter--;
                }
            }
            end++;
            
            while(counter==0){
                char c2 = s.charAt(begin);
                if(hashmap.containsKey(c2)){
                    if(hashmap.get(c2)==0){
                        counter++;
                    }
                    hashmap.put(c2,hashmap.get(c2)+1);
                }
                if(end-begin<len){
                    len=end-begin;
                    head=begin;
                }
                begin++;
            }
        }
        if(len==Integer.MAX_VALUE) return "";
        return s.substring(head,head+len);
    }
}
//Time O(n)
//Space O(1)