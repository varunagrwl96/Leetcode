class FirstUnique {
    
    LinkedHashSet<Integer> set;
    HashSet<Integer> dups;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet();
        dups = new HashSet();
        for(int num : nums){
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        if(!set.isEmpty()){
            return set.iterator().next();
        }
        return -1;
    }
    
    public void add(int value) {
        if(dups.contains(value)){
            return;
        }
        boolean added = set.add(value);
        if(!added){
            dups.add(value);
            set.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */