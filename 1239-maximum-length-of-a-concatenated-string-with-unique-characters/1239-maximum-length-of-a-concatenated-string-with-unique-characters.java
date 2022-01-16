class Solution {
    public int maxLength(List<String> arr) {
        int max=0;
        List<String> result = new ArrayList();
        result.add("");
        for(String str : arr){
            for(int i=0;i<result.size();i++){
                Set<Character> set = new HashSet();
                String newStr = result.get(i)+str;
                for(char c : newStr.toCharArray()){
                    set.add(c);
                }
                if(set.size()!=newStr.length()){
                    continue;
                }
                result.add(newStr);
                max=Math.max(max,newStr.length());
            }
        }
        return max;
    }
}