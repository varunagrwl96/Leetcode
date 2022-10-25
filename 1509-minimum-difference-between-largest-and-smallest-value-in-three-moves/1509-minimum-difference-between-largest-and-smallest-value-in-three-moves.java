class Solution {
    public int minDifference(int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
}

// We have 4 plans:

// kill 3 biggest elements
// kill 2 biggest elements + 1 smallest elements
// kill 1 biggest elements + 2 smallest elements
// kill 3 smallest elements