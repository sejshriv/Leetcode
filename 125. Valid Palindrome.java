/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 
*/
class Solution {
    public static boolean isAlpNum(char c){
        if(Character.isAlphabetic(c) || (c>='0' && c<='9'))
        return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(isAlpNum(s.charAt(i))){
                if(isAlpNum(s.charAt(j))){
                    if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                    return false;
                    i++;j--;
                    continue;
                }
                j--;
                continue;
            }
            i++;
        }
        return true;
    }
}
