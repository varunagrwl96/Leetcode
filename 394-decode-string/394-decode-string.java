class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!=']'){
                stack.push(c);
            }else{
                sb=new StringBuilder();
                sb2=new StringBuilder();
                while(!stack.isEmpty() && Character.isAlphabetic(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                stack.pop(); //remove ]
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb2.insert(0,stack.pop());
                }
                int times = Integer.parseInt(sb2.toString());
                while(times>0){
                    for(char ch : sb.toString().toCharArray()){
                        stack.push(ch);
                    }
                    times--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
            
        //     if(Character.isDigit(c)){
        //         stack.push(String.valueOf(c));
        //     }else if(c=='['){
        //         currsb= new StringBuilder();
        //     }else if(Character.isAlphabetic(c)){
        //         currsb.append(c);
        //     }else if(c==']'){
        //         int times = Integer.parseInt(stack.pop());
        //         while(times>0){
        //             sb.append(currsb);
        //             times--;
        //         }
        //         // stack.push(sb.toString());
        //     }
        // }
        // StringBuilder ans = new StringBuilder();
        // while(!stack.isEmpty()){
        //     sb.append(stack.pop());
        // }
        // return sb.reverse().toString();
        // return sb.toString();
    }
}