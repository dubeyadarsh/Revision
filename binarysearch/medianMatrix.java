public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int i=0,j=(int)1e9;
        while(i<=j){
            // I have to find that lowest element so that total number of 
            // element less than or equal to that number must be greater than n*m/2;
            int mid=i+(j-i)/2;
            int count=findelem(matrix,mid,m,n);

            if(count<=n*m/2) i=mid+1;
            else j=mid-1;
        }
        return i;
    }
    static int findelem(int[][] matrix,int target,int m,int n)
    {
        int ans=0;

        for(int i=0;i<m;i++){
           int l=0,h=n-1;
           int temp=0;
           while(l<=h){
               int mid=l+(h-l)/2;
                if(matrix[i][mid]<=target){
                    temp=mid+1;
                    l=mid+1;
                }else h=mid-1;
           }
           ans+=temp;
        }
        return ans;
    }
}
