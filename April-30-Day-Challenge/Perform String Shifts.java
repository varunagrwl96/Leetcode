class Solution {
    public String stringShift(String s, int[][] shift) {
        String ans;
        int lrshift=0;
        for(int i=0;i< shift.length;i++){
            if(shift[i][0]==0){
                lrshift-=shift[i][1];
            }else{
                lrshift+=shift[i][1];
            }
        }
        int size = s.length();
        lrshift=lrshift%size;
        if(lrshift>0){
            ans = s.substring(size-lrshift)+s.substring(0,size-lrshift);
        }else{
            ans = s.substring(-lrshift)+s.substring(0,-lrshift);
            }
        return ans;
    }
}