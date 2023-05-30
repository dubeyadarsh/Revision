// 2 for loop and 3rd element k liye 2 pointer algorithm use kar lo. 
// 2 pointer algo use karte time agar num[i]==num[i+1] rahe to extra while loop lagake i++ kar lena and 
// same for j .because unique tuple puchha hai 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
          int n=nums.length;
          List<List<Integer>> list=new ArrayList<>();
          Arrays.sort(nums);
         for(int m=0;m<n-2;m++){
            int i=m+1,j=n-1;
            if(m==0 ||(m>0 && nums[m]!=nums[m-1])){
           while(i<j){
               if(nums[i]+nums[j]+nums[m]==0) {
                   ArrayList<Integer> ll=new ArrayList<>();
                   ll.add(nums[m]);
                   ll.add(nums[i]);
                   ll.add(nums[j]);
                   list.add(ll);
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                i++;
                j--;
               }
               else if(nums[i]+nums[j]+nums[m]>0) j--;
                else i++;
              
        }
           }
    }
    return list;
}
}
