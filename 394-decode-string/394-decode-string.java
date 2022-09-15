class Solution {
    public String decodeString(String s) {
        
        int n = s.length();
        String ans="";
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c!=']'){
                stack.push(c);
            }else{
                //Get string
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isAlphabetic(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                stack.pop(); //remove [                
                    
                //Get count
                StringBuilder sb2 = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb2.insert(0,stack.pop());    
                }
                
                //Create string
                int count = Integer.parseInt(sb2.toString());
                while(count>0){
                    for(char ch : sb.toString().toCharArray())  
                        stack.push(ch);
                    count--;
                }
            }
        }
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty())
            retv.insert(0, stack.pop());
        return retv.toString();
    }
}