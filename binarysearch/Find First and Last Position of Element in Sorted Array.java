

// First approach is not optmised for [7,7,7,7,7,7] . for this testcase, time complexity will become O(n).
//  So instead of this we could use binary search 2 times .
  
  
  1)                  class Solution {
                      public int[] searchRange(int[] nums, int target) {
                          int l=0;
                          int r=nums.length-1;
                          int ans[]=new int[2];
                          ans[0]=-1;
                          ans[1]=-1;
                          while(l<=r){
                              int mid=l+(r-l)/2;

                              if(nums[mid]==target){
                                  int j=mid;
                                  while(mid>0 && nums[mid]==nums[mid-1] ) mid--;
                                  while(j<nums.length-1 && nums[j]==nums[j+1] ) j++;
                              ans[0]=mid;
                              ans[1]=j;
                                  return ans;
                              }
                              else if(nums[mid]<target){
                                  l=mid+1;
                              }else r=mid-1;

                          }
                          return ans;
                      }
                  }



2) 
  class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=firstOccurence(nums,target);
        int j=lastOccurence(nums,target);

        return new int[]{i,j};
    }
    int firstOccurence(int [] nums,int target){
        int i=0,j=nums.length-1;
        int first=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                first=mid;
                j=mid-1;
            }else if(nums[mid]>target){
                j=mid-1;
            }else i=mid+1;
        }
        return first;
    }
    int lastOccurence(int [] nums,int target){
        int i=0,j=nums.length-1;
        int last=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                last=mid;
                i=mid+1;
            }else if(nums[mid]>target){
                j=mid-1;
            }else i=mid+1;
        }
        return last;
    }
}
