class SparseVector {
    
    int[] sparse;
    
    SparseVector(int[] nums) {
        sparse = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] sparse2 = vec.sparse;
        int ans=0;
        for(int i=0;i<sparse.length;i++){
            ans +=sparse[i]*sparse2[i];
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);