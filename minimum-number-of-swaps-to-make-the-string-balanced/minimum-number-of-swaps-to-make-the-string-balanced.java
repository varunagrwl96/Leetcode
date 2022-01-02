class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='['){
                stack.push('[');
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    stack.push(']');
                }
            }
        }
        System.out.println(stack.size());
        return (int)Math.ceil(stack.size()/2);
    }
}