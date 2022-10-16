class Solution {
    public boolean checkValidString(String s) {
        char[] charArray = s.toCharArray();
        int size = charArray.length;
        int count_star = 0;
        int sum = 0;
        for(int i=0;i<size;i++){
            if(charArray[i]=='(' ){
                sum++;
            }else if(charArray[i]=='*'){
                count_star++;
            }else{
                if(sum>0){
                    sum--;
                }else if(count_star>0){
                    count_star--;
                }else{
                    return false;
                }
            }
        }
        
        sum=0;
        count_star=0;
        for(int i=size-1;i>=0;i--){
            if(charArray[i]==')' ){
                sum++;
            }else if(charArray[i]=='*'){
                count_star++;
            }else{
                if(sum>0){
                    sum--;
                }else if(count_star>0){
                    count_star--;
                }else{
                    return false;
                }
            }
        }
        return true; 
            
    }
}