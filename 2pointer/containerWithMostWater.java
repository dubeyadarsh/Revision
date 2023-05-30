// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int ans=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            ans=Math.max(ans,h*w);
            if(height[i]>height[j]) j--;
            else i++;
        }
        return ans;
    }
}
