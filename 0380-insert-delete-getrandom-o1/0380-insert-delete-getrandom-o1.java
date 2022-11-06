class RandomizedSet {
    
    HashSet<Integer> hashset;
    Random r;
    public RandomizedSet() {
        hashset = new HashSet();
        r = new Random();
    }
    
    public boolean insert(int val) {
        return hashset.add(val);
    }
    
    public boolean remove(int val) {
        return hashset.remove(val);
    }
    
    public int getRandom() {
        int index = r.nextInt(hashset.size());
        List<Integer> list = new ArrayList(hashset);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */