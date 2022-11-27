class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        String[] mappings = new String[]{
          "0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        if(digits==null || digits.length()==0){
            return result;
        }
        recursive(digits,result,0,"",mappings);
        return result;
    }
    
    
    public void recursive(String digits, List<String> result, int index, String combination,String[] mappings){
        if(index==digits.length()){
            result.add(combination);
            return;
        }
        String curr = mappings[digits.charAt(index)-'0'];
        for(int i=0;i<curr.length();i++){
            recursive(digits,result,index+1,combination+curr.charAt(i),mappings);
        }
    }
}