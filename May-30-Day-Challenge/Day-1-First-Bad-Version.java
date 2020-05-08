/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       return getIndex(1,n);
    }
    
    public int getIndex(int start, int end){
        int index = start + (end-start)/2;
        if(isBadVersion(index)){
            if(!isBadVersion(index-1)){
                return index;
            }else{
                return getIndex(1,index-1);
            }
        }else{
            return getIndex(index+1,end);
        }
    }
}
------------------------------------------------
public class Solution extends VersionControl {
public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;            
    }        
    return start;
	}
}