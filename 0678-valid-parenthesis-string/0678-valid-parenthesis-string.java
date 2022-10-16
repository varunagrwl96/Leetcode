class Solution {
    public boolean checkValidString(String s) {
        int count=0;
        int stars=0;
        int n=s.length();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='('){
                count++;   
            }else if(curr=='*'){
                stars++;
            }else if(curr==')'){
                if(count>0){
                    count--;
                }else if(stars>0){
                    stars--;
                }else{
                    return false;
                }
            }
        }
        //reverse check
        count=0;
        stars=0;
        for(int i=n-1;i>=0;i--){
            char curr = s.charAt(i);
            if(curr==')'){
                count++;   
            }else if(curr=='*'){
                stars++;
            }else if(curr=='('){
                if(count>0){
                    count--;
                }else if(stars>0){
                    stars--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}