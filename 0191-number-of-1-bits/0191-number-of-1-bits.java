public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones=0;
        // while(n!=0){
            String x = Integer.toBinaryString(n);
            for(char c : x.toCharArray()){
                if(c=='1'){
                    ones++;
                }
            }
            // int one = n%2;
            // n=n>>1;
            // if(one==1){
            //     ones++;
            // }
        // }
        return ones;
    }
}