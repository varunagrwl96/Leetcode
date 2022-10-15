class Solution {
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int length = s.length();
        HashMap<Character,Integer> hashmap = new HashMap();
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);
        int sum=0;
        for(int i=0;i<length-1;i++){
            int curr=hashmap.get(roman[i]);
            int next =hashmap.get(roman[i+1]);
            if(curr<next){
                sum-=curr;
            }else{
                sum+=curr;
            }
            
        }
        sum =sum+hashmap.get(roman[length-1]);
        return sum;
    }
}