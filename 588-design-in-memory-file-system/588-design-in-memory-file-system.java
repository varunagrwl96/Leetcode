class FileSystem {
    class Dir{
        HashMap<String,Dir> dirs = new HashMap();
        HashMap<String,String> files = new HashMap();
    }
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir temp = root;
        List<String> res = new ArrayList();
        if(!path.equals("/")){
            String[] splits = path.split("/");
            for(int i=1;i<splits.length-1;i++){
                temp = temp.dirs.get(splits[i]);
            }
            if(temp.files.containsKey(splits[splits.length-1])){
                res.add(splits[splits.length-1]);
                return res;
            }else{
                temp = temp.dirs.get(splits[splits.length-1]);
            }
        }
        res.addAll(new ArrayList<>(temp.dirs.keySet()));
        res.addAll(new ArrayList<>(temp.files.keySet()));
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        Dir temp = root;
        String[] splits = path.split("/");
        for(int i=1;i<splits.length;i++){
            if(!temp.dirs.containsKey(splits[i])){
                temp.dirs.put(splits[i],new Dir());
            }
            temp = temp.dirs.get(splits[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir temp = root;
        String[] splits = filePath.split("/");
        for(int i=1;i<splits.length-1;i++){
            temp = temp.dirs.get(splits[i]);
        }
        temp.files.put(splits[splits.length-1],temp.files.getOrDefault(splits[splits.length-1],"")+content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir temp = root;
        String[] splits = filePath.split("/");
        for(int i=1;i<splits.length-1;i++){
            temp = temp.dirs.get(splits[i]);
        }
        return temp.files.get(splits[splits.length-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */