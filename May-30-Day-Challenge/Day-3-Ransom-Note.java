class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hashmap = new HashMap();
        for(char c : magazine.toCharArray()){
            if(hashmap.containsKey(c)){
                int count = hashmap.get(c);
                hashmap.put(c,count+1);
            }else{
                hashmap.put(c,1);
            }
        }
        for(char c : ransomNote.toCharArray()){
            if(hashmap.containsKey(c)){
                int count = hashmap.get(c);
                if(count==0){
                    return false;
                }
                hashmap.put(c,--count);
            }else{
                return false;
            }
        }
    return true;
        
    }
}
Slower solution than Hashmap.
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c);
            if(index == -1){
                return false;
            }
            magazine = magazine.replaceFirst(Character.toString(c),"1");
            // magazine = magazine.substring(0,index)+'1'+magazine.substring(index+1);
        }
        return true;
    }
}