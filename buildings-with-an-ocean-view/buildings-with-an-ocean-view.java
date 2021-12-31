class Solution {
    public int[] findBuildings(int[] heights) {
        int n=heights.length;
        int max = 0;
        List<Integer> ans = new ArrayList();
        for(int i=n-1;i>=0;i--){
            if(heights[i]>max){
                ans.add(i);
            }
            max=Math.max(max,heights[i]);
        }
        int[] arr = new int[ans.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }
}