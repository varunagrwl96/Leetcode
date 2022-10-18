// class Solution {
//     public int kthFactor(int n, int k) {
//         int count=0;
//         for(int i=1;i<=n;i++){
//             if(n%i==0){
//                 count++;
//                 if(count==k){
//                     return i;
//                 }
//             }
//         }
//         return -1;
//     }
// }
// Just loop until square root of n, by caching the other facters to a list.
// i will track factors from 1, List will cache factors from n, then converge to sqrt(n);
// just try count the kth, based on above logic.
class Solution{
    public int kthFactor(int n, int k) {
        int cnt = 0;
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i != n) l.add(n / i);
                if (++cnt == k) return i;
            }
        }
        if (l.size() + cnt < k) return -1;
        return l.get(l.size() - (k - cnt));
    }
}