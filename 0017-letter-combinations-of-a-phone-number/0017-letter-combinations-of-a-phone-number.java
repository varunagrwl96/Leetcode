class Solution {
    List<String> ans = new ArrayList();
    public List<String> letterCombinations(String digits) {
        String[][] map = new String[][]{null,null,{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        
        if(digits==null || digits.length()==0) return ans;
            
        recursion(digits,map,"",0);
        return ans;
    }
    
    public void recursion(String digits, String[][] map, String combination, int index){
        if(combination.length()==digits.length()){
            ans.add(combination);
            return;
        }
        int curr = digits.charAt(index)-'0';
        String[] digitmap = map[curr];
        for(String x : digitmap){
            recursion(digits,map,combination+x,index+1);
        }
    }
}