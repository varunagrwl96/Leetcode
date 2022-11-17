class Solution {
    public boolean winnerOfGame(String colors) {
        int[] groups = new int[colors.length()];
        groups[0]=1;
        int index=0;
        int alice=-1;
        if(colors.charAt(0)=='A'){
            alice=0;
        }else{
            alice=1;
        }
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                groups[index]++;
            }else{
                groups[++index]=1;
            }
        }
        int asteps=0;
        int bsteps=0;
        for(int i=0;i<groups.length;i++){
            if(groups[i]>=3){
                if(alice==0){
                    if(i%2==0){
                        asteps+=groups[i]-2;
                    }else{
                        bsteps+=groups[i]-2;
                    }
                }else{
                    if(i%2==0){
                        bsteps+=groups[i]-2;
                    }else{
                        asteps+=groups[i]-2;
                    }
                }
            }
        }
        return asteps>bsteps;
    }
}