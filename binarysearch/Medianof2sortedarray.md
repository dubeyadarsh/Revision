https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// Median hamesha mid me hota hai,toh dono array ko merge karne pe joh mid me aayega woh median hoga
// but it's not that easy, 
// We can find the right partition of left and right array like hume 

![image](https://github.com/dubeyadarsh/Revision/assets/75479397/13982853-48c7-40f1-b202-69525a85b917)
![image](https://github.com/dubeyadarsh/Revision/assets/75479397/766db6fa-be6b-4bf0-a42a-4c6fc7131959)

![image](https://github.com/dubeyadarsh/Revision/assets/75479397/9cda0ba9-5689-46e7-8168-d77463670cc9)

{
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
           return  findMedianSortedArrays(nums2, nums1);
                
        }
        int lo=0,hi=n1;
        while(lo<=hi){
            int c1=lo+(hi-lo)/2;
            int c2=((n1+n2)/2) - c1;
            double l1=c1==0?Integer.MIN_VALUE:nums1[c1-1];
            double l2=c2==0?Integer.MIN_VALUE:nums2[c2-1];
            double r1=c1==n1?Integer.MAX_VALUE:nums1[c1];
            double r2=c2==n2?Integer.MAX_VALUE:nums2[c2];
            if(l1>r2){
                hi=c1-1;
            }
            else if(l2>r1){
                lo=c1+1;
            }
            else{
                 return (n1+n2)%2==0?                           (Math.max(l1,l2)+Math.min(r1,r2))/2:Math.min(r1,r2);
            }
        }
        return -1;
    }
}
}
