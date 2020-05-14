class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if(length==k) return "0";
        Stack<Character> stack = new Stack();
        for(int i=0;i<length;i++){
            
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;            
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>1 &&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}
