class Solution {
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for(char c : S.toCharArray()){
            if(J.contains(Character.toString(c))){
                ++count;
            }
        }
        return count;
    }
}
--------------------------------
No char conversions
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for(int i=0;i<S.length();i++){
            if(J.contains(S.substring(i,i+1))){
                ++count;
            }
        }
        return count;
    }
}