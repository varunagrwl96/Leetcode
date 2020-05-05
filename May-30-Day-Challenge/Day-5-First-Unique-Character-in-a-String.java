class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> hashmap = new LinkedHashMap();
        int size = s.length();
        Character ans = 'A';
        for(int i=0;i<size;i++){
            Character letter = s.charAt(i);
            if(hashmap.containsKey(letter)){
                hashmap.put(letter,hashmap.get(letter)+1);
            }else{
                hashmap.put(letter,1);
            }
        }
        Iterator itr = hashmap.entrySet().iterator();
        while(itr.hasNext()){
             Map.Entry<Character,Integer> mapentry= (Map.Entry)itr.next();
            if(mapentry.getValue().equals(1)){
                ans = mapentry.getKey();
                break;
            }
        }
        return s.indexOf(ans);
    }
}
-------------------------------------------
Faster solution
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++){
            freq [s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++){
            if(freq [s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}