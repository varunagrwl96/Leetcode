class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = nums1.length-1;
        int i=m-1, j=n-1;
        while(total>=0){
            int num1 = i>=0 ? nums1[i] : Integer.MIN_VALUE;
            int num2 = j>=0 ? nums2[j] : Integer.MIN_VALUE;
            if(num1>num2){
                nums1[total]=num1;
                i--;
            }else{
                nums1[total]=num2;
                j--;
            }
            total--;
        }
    }
}