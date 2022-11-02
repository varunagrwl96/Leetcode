class SnapshotArray {

    int snapid=0;
    TreeMap<Integer,Integer>[] treemap;
    
    public SnapshotArray(int length) {
        treemap = new TreeMap[length];
        for(int i=0;i<length;i++){
            treemap[i] = new TreeMap();
            treemap[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        treemap[index].put(snapid,val);
    }
    
    public int snap() {
        return snapid++;
    }
    
    public int get(int index, int snap_id) {
        return treemap[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */