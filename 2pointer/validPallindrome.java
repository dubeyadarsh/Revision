// https://leetcode.com/problems/valid-palindrome/

class Solution {

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int len=s.length();
        int i=0,j=len-1;
     
        while(i<j){
            while(i<j && ((s.charAt(i)<'a' && !((s.charAt(i)>='0' && s.charAt(i)<='9'))) || s.charAt(i)>'z'))i++;
            while(i<j && ((s.charAt(j)<'a' && !((s.charAt(j)>='0' && s.charAt(j)<='9'))) || s.charAt(j)>'z'))j--;

            if(s.charAt(i)!=s.charAt(j)) return false;
           

            i++;
            j--;
        }
        return true;
    }
}
