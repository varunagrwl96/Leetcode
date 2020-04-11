class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String,List<String>> hashmap = new HashMap();
	        for(int i=0;i<strs.length;i++){
	            char[] words = strs[i].toCharArray();
	            Arrays.sort(words);
	            String word = new String(words);
	            if(hashmap.containsKey(word)){
	                List<String> stringList = hashmap.get(word);
	                stringList.add(strs[i]);
	                hashmap.put(word,stringList);
	            }else{
	                List<String> stringList = new ArrayList();
	                stringList.add(strs[i]);
	                hashmap.put(word,stringList);
	            }
	        }
	        List<List<String>> ans = new ArrayList();
	        Iterator itr = hashmap.entrySet().iterator();
	        while(itr.hasNext()) {
	        	Map.Entry mapEntry= (Map.Entry)itr.next();
	        	ans.add((List)mapEntry.getValue());
	        }
        return ans;
    }
}