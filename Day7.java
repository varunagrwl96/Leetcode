class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int prev=0,count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[prev]+1){
                count=count+i-prev;
                prev=i;
            }else if(arr[i]>arr[prev]+1){
                prev=i;
            }
        }
        return count;
    }
}