class Solution {
    // List<Integer> ans = new ArrayList();
    int max=9;
    int min=0;
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        Queue<Integer> output = recursive(queue,--n,k);
        int[] ans = output.stream().mapToInt(i->i).toArray();
        return ans;
    }
    
    public Queue<Integer> recursive(Queue<Integer> queue, int n, int k){
        if(n==0){
            return queue;
        }
        Queue<Integer> newq = new LinkedList();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int min_new=0, max_new=0;
            int digit=curr%10;
            if(digit-k>=min){
                min_new = curr*10+ (digit-k);
                newq.add(min_new);
            }
            if(digit+k<=max && k!=0){
                max_new = curr*10+(digit+k);
                newq.add(max_new);
            }
        }
        return recursive(newq,--n,k);
        // return newq;
    }
}
//O(2^N)
//O(2^N)