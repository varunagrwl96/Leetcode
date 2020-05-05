class Solution {
    public int findComplement(int num) {
       int[] binaryArray = new int[32];
        int index = 0;
        while(num>0){
            binaryArray[index] = (num%2)==0 ? 1: 0;
            num=num/2;
            ++index;
        }
        int ans=0;
        for(int i = 0; i<binaryArray.length;i++){
            ans= (int) (ans + binaryArray[i]*Math.pow(2,i));
        }
        return ans;
    }
}
-------------------------------
Another quicker solution based on known property: 
1)Keep summing the number(in binary powers) till it is greater than the given number.
2)Then subtract the given number from this number which gives the complement of the given number.
 public int findComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        
        return i - num;
    }