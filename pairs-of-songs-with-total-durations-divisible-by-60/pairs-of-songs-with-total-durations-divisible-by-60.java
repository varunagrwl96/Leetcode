class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int i=0;i<time.length;i++){
            hashmap.put(time[i]%60,hashmap.getOrDefault(time[i]%60,0)+1);
        }
        int count=0;
        for(int i=0;i<time.length;i++){
            int reqd = 60 - time[i]%60;
            reqd=reqd%60;
            if(hashmap.containsKey(reqd)){
                if(reqd!=0 && reqd!=30){
                    System.out.println(reqd+","+time[i]);
                    count+=hashmap.get(reqd);
                }else{
                    System.out.println(reqd+","+time[i]);
                    count+=hashmap.get(reqd)-1;
                }
            }
        }
        count =count/2;
        return count;
    }
}