class FirstUnique {
    
    LinkedHashSet<Integer> set;
    HashMap<Integer,Boolean> isdup;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet();
        isdup = new HashMap();
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
        if(isdup.containsKey(value)){
            isdup.put(value,true);
            set.remove(value);
        }else{
            isdup.put(value,false);
            set.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */