class Solution {
    public int longestMountain(int[] arr) {
        int i=1;
        int n=arr.length;
        int len1=1;
        int len2=0;
        int max=0;
        while(i<n){
            if(arr[i]>arr[i-1]){
                while(i<n && arr[i]>arr[i-1]){
                    len1++;
                    i++;
                }
                while(i<n && arr[i]<arr[i-1]){
                    len2++;
                    i++;
                }
                if(len1+len2>=3 && len1!=0 && len2!=0){
                    max=Math.max(max,len1+len2);
                }
                len1=1;
                len2=0;
            } else {
                i++;
            }
        }
        return max;
    }
}