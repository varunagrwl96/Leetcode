class RandomizedSet {
    
    HashMap<Integer,Integer> hashmap;
    Random r;
    List<Integer> list;
    public RandomizedSet() {
        hashmap = new HashMap();
        r = new Random();
        list=new ArrayList();
    }
    
    public boolean insert(int val) {
        if(hashmap.containsKey(val)) return false;
        list.add(val);
        hashmap.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        
        //list remove with value/index is O(n) coz all elements in the right needs to be shifted
        //So swap the last value with curr val and remove the last element
        //Need index of curr removing element, thus need hashmap instead of hashset
        if(!hashmap.containsKey(val)) return false;
        int index = hashmap.get(val);
        //Swap
        // Collections.swap(list,index,list.size()-1);
        // int swappedWith = list.get(index);
        int last = list.get(list.size()-1);
        list.set(index,last);
        hashmap.put(last,index); //Update hashmap index for last ele
        list.remove(list.size()-1);
        hashmap.remove(val);
        return true;
        
        
        // int ind = valToInd.getOrDefault(val,-1);
        // if(ind == -1) return false;
        // Collections.swap(list,ind,list.size()-1);
        // int swappedWith = list.get(ind);
        // valToInd.put(swappedWith,ind);
        // list.remove(list.size()-1);
        // valToInd.remove(val);
        // return true;
    }
    
    public int getRandom() {
        int index = r.nextInt(list.size());
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