class LRUCache {
    LinkedHashMap<Integer,Integer> linkedmap;
    int capacity;

    public LRUCache(int capacity) {
        linkedmap = new LinkedHashMap();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(linkedmap.containsKey(key)){
            int value = linkedmap.get(key);
            linkedmap.remove(key);
            linkedmap.put(key,value);
            return linkedmap.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(linkedmap.size()==capacity){
            if(linkedmap.containsKey(key)){
                linkedmap.remove(key);
                linkedmap.put(key,value);
            }else{
                linkedmap.remove(linkedmap.keySet().toArray()[0]);
                linkedmap.put(key,value);
            }
        }else{
            if(linkedmap.containsKey(key)){
                linkedmap.remove(key);
                linkedmap.put(key,value);
            }else{
                linkedmap.put(key,value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */