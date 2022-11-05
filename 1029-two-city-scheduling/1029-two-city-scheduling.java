class Solution {
  public int twoCitySchedCost(int[][] costs) {
//     Sort the persons in the ascending order by price_A - price_B parameter, which indicates the company additional costs.

// To minimise the costs, send n persons with the smallest price_A - price_B to the city A, and the others to the city B.
      
    Arrays.sort(costs, (i1,i2) -> (i1[0]-i1[1]) - (i2[0]-i2[1]));

    int total = 0;
    int n = costs.length / 2;
    // To optimize the company expenses,
    // send the first n persons to the city A
    // and the others to the city B
      for(int i=0;i<costs.length;i++){
          if(i<n){
            total+=costs[i][0];   
          }else{
            total+=costs[i][1];
          }
      }
    return total;
  }
}