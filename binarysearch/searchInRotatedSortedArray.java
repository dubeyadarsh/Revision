class Solution {
    public int search(int[] nums, int target) {
      // Concept: If left is not sorted then right part must be sorted and vice versa.
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            //check left sorted? 
            if(nums[mid]==target) return mid;
            if(nums[i]<=nums[mid]){
              if(nums[mid]>target && nums[i]<=target) j=mid-1;
              else i=mid+1;
            } //sorted
            else{
                if(nums[mid]<target && nums[j]>=target) i=mid+1;
              else j=mid-1;
            }
        }
        return -1;
    }
}
