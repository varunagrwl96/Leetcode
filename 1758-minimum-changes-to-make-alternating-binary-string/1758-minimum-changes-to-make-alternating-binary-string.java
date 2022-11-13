class Solution {
    public int minOperations(String s) {
        char case1='0';
        char case2='1';
        int count1=0;
        for(char c : s.toCharArray()){
            if(c!=case1){
                count1++;
            }
            case1=case1=='1'?'0':'1';
        }
        int count2=0;
        for(char c : s.toCharArray()){
            if(c!=case2){
                count2++;
            }
            case2=case2=='1'?'0':'1';
        }
        return Math.min(count1,count2);
    }
}