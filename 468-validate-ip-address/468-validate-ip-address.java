class Solution {
    public String validIPAddress(String queryIP) {
        boolean ipv4 = validateIPv4(queryIP);
        boolean ipv6 = validateIPv6(queryIP);
        if(ipv4)
            return "IPv4";
        if(ipv6)
            return "IPv6";
        return "Neither";
    }
    
    public boolean validateIPv4(String input){
        String[] split = input.split("\\.",-1);
        if(split.length!=4) return false;
        int value=-1;
        for(String x : split){
            if(x==null || x.length()==0) return false;
            value=0;
            for(char c : x.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }
            }
            if(x.charAt(0)=='0'){
                if(x.length()>=2){
                    return false;
                }
            }else{
                try{
                value = Integer.parseInt(x);
                }catch(NumberFormatException e){
                    return false;
                }
            }
            if(value<0 || value > 255){
                return false;
            }
        }
        return true;
    }
    
    public boolean validateIPv6(String input){
        String[] split = input.split(":",-1);
        if(split.length!=8) return false;
        int value=-1;
        for(String x : split){
            if(x==null) return false;
            int n = x.length();
            if(n<1 || n>4) return false;
            for(char c : x.toCharArray()){
                if(Character.isAlphabetic(c)){
                    c = Character.toLowerCase(c);
                    int number=c-'a';
                    if(number<0 || number>5) return false;
                }
            }
        }
        return true;
    }
}