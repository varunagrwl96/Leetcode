class Solution {
    public int maxTurbulenceSize(int[] arr) {
        //Question boils down to  counting valleys and mountains
        //A valley is ex 3  1  4 ==> 1 is smaller than both left and right element
    //A mountain is ex 5 8 4 ==> 8 is greater  than both right and left elemnt 
        //To contribute in mountains or valleys we'll need three elements and then will make a check 
        
        if(arr.length<2)return arr.length;
        int max = 1;
        int start = 0;
        int end = 0;
        while(start<arr.length-1){
            //if the two elements are equal it will help in make a skip
            if(arr[start]==arr[start+1]){
                start++;
                continue;
            }
            end = start+1;
            while(end+1<arr.length && isTur(arr,end)){
                end++;
            }
            //Finding the max subarray and updating the ans
            max = Math.max(max,end-start+1);
            //reseting the start to current end
            start = end;
        }
     return max;   
    }
    //Simple function to check for either valleys or mountains
    
    //return true if any of them is true
    private boolean isTur(int[] arr, int k){
            return(arr[k] > arr[k+1] && arr[k]>arr[k-1]) || (arr[k]<arr[k+1] && arr[k] < arr[k-1]);
        }
}