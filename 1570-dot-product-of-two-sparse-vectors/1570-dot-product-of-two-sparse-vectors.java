class SparseVector {
    
    // int[] sparse;
    // HashMap<Integer,Integer> hashmap = new HashMap();
    List<int[]> pairs;
    
    SparseVector(int[] nums) {
        // sparse = nums;
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        // int[] sparse2 = vec.sparse;
        // int ans=0;
        // for(int i=0;i<sparse.length;i++){
        //     ans +=sparse[i]*sparse2[i];
        // }
        // return ans;
        // int ans=0;
        // HashMap<Integer,Integer> hashmap2 = vec.hashmap;
        // for(int key : hashmap.keySet()){
        //     if(hashmap2.containsKey(key))
        //     ans+=hashmap.get(key)*hashmap2.get(key);
        // }
        // return ans;
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                q++;
            }
            else {
                p++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);