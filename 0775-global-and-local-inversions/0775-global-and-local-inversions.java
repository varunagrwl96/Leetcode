class Solution {
    public boolean isIdealPermutation(int[] A) {
        //A local inversion is also a global inversion. Thus, we only need to check if our permutation has any non-local inversion (A[i] > A[j], i < j) with j - i > 1.
        // int N = A.length;
        // for (int i = 0; i < N; ++i)
        //     for (int j = i+2; j < N; ++j)
        //         if (A[i] > A[j]) return false;
        // return true;
        int N = A.length;
        int floor = N;
        for (int i=N-1; i>=2; --i) {
            floor = Math.min(floor, A[i]);
            if (A[i-2] > floor) return false;
        }
        return true;
    }
}

// 0 1 2 3 4 5
// 1 2 3 4 5 0