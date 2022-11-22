class Solution {
    Integer[][] memo;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        memo = new Integer[piles.size()+1][k+1];
        return recursion(piles,k, 0);
    }
    
    public int recursion(List<List<Integer>> piles, int k, int index){
        if(k==0 || index==piles.size()){
            return 0;
        }
        if(memo[index][k]!=null) return memo[index][k];
        int res = recursion(piles,k,index+1);
        int curr=0;
        for(int j=0;j<Math.min(piles.get(index).size(),k);j++){
            curr+=piles.get(index).get(j);
            res = Math.max(res, curr + recursion(piles,k-j-1,index+1));
        }
        memo[index][k]=res;
        return res;
    }
}