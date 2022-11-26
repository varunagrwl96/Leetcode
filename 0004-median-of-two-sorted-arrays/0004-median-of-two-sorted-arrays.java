// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] a;
//         int[] b;
//         if(nums1.length<=nums2.length){
//             a=nums1;
//             b=nums2;
//         }else{
//             a=nums2;
//             b=nums1;
//         }
        
//         int m = a.length;
//         int n = b.length;
//         int half = (m+n)/2;
//         int l=0;
//         int r=m-1;
        
//         while(l<r){
//             int i = (l+r)/2;
//             int j = half-i-2;
//             // System.out.println(l+" "+r);
            
//             int aleft=Integer.MIN_VALUE;
//             if(i>=0){
//                 aleft=a[i];
//             }
//             int aright = Integer.MAX_VALUE;
//             if(i+1<m){
//                 aright=a[i+1];
//             }
//             int bleft = Integer.MIN_VALUE;
//             if(j>=0){
//                 bleft=b[j];
//             }
//             int bright=Integer.MAX_VALUE;
//             if(j+1<n){
//                 bright=b[j+1];
//             }
            
//             if(aleft<=bright && bleft<=aright){
//                 if((m+n)%2==1){ //odd
//                     return Math.min(aright,bright);
//                 }else{
//                     return (Math.max(aleft,bleft)+Math.min(aright,bright))/2.0;
//                 }
//             }else if(aleft>bright){
//                 r=i-1;
//             }else{
//                 l=i;
//             }
//         }
//         return -2;
//     }
// }
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0;
        }
        
        if(nums1 == null){
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }
        
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;
        
        while(left < right){
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;
            
            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else{
                right = i;
            }
        }
        
        int first = left;
        int second = (n + m) / 2 - left;
        
        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];
        
        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];
        
        if((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return (Math.max(shorterLeft, longerLeft) + Math.min(shorterRight, longerRight)) / 2.0;
        }
 

        
    }
}
