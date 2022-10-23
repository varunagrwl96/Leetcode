class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!stack.isEmpty() && stack.peek().getKey()==curr){
                Pair<Character,Integer> popped = stack.pop();
                if(popped.getValue()<k-1){
                    stack.push(new Pair(curr,popped.getValue()+1));
                }else if(popped.getValue()==k-1){
                    continue;
                }
            }else{
                stack.push(new Pair(curr,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character,Integer> popped = stack.pop();
            int times = popped.getValue();
            while(times>0){
                sb.insert(0,popped.getKey());
                times--;
            }
        }
        return sb.toString();
    }
}