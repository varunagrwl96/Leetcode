class Solution {
    public boolean squareIsWhite(String coordinates) {
        if(coordinates==null) return false;
        char c = coordinates.charAt(0);
        int value = Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        boolean valueEven=false;
        HashSet<Character> even = new HashSet(Arrays.asList(
'b','d','f','h'));
        if(value%2==0) valueEven=true;
        if(even.contains(c)){
            if(valueEven){
                return false;
            }else{
                return true;
            }
        }else{
            if(valueEven){
                return true;
            }else{
                return false;
            }
        }
    }
}