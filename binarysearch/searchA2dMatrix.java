class Solution {
    //First identify that in which row target can lie then once u get the row 
//   use binary search to find where element is present in that row.
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=matrix[0].length-1;

        int i=0;
        while(i<=row){
            int midro=i+(row-i)/2;
            if(matrix[midro][0]>target) row=midro-1;
            else {
                if(matrix[midro][col]<target) i=midro+1;
                else{
                  int j=0;
                  int coll=col;
                  while(j<=coll)     {
                      int midco=j+(coll-j)/2;
                      if(matrix[midro][midco]==target) return true;
                      else if(matrix[midro][midco]>target) coll=midco-1;
                      else j=midco+1;
                  }
                  return false;
                }
            }
        }
        return false;
    }
}
