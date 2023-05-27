https://leetcode.com/problems/sliding-window-maximum/description/

**class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
            // Deque<Integer> deque=new LinkedList<>();
        int i=0;
        int ans[]=new int[nums.length-k+1];
        //Maintain decreasing fashion and remove all elements which are smaller than current element and also occurs before than current element.
        for(;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){ deque.removeLast();}
            deque.addLast(i);
        }

        for(;i<nums.length;i++){
            // Get the max element from the window and store it
            ans[i-k]=nums[deque.peekFirst()];
            // Remove elements which are out of range
               while(!deque.isEmpty() && deque.peekFirst()<=i-k){ deque.removeFirst ();
               }
               while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {deque.removeLast();
               }
            deque.addLast(i);
        }
        ans[i-k]=nums[deque.peekFirst()];	       
	    return ans;
    }
}**                                                                         
![photo_6309663766983325280_y](https://github.com/dubeyadarsh/Revision/assets/75479397/0ea02ce3-69ed-42b0-8385-a028127c9f5a)


                                                                         
                                                                         
