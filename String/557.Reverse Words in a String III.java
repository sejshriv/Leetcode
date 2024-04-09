/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "Mr Ding"
Output: "rM gniD"
 
Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.

*/

class Solution {
    public void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char x = arr[start];
            arr[start] = arr[end];
            arr[end] = x;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        int start = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(i == arr.length-1 || arr[i+1] == ' ') {
                reverse(arr, start, i);
                start = i+2; // avoid space
            }
        }
        return new String(arr);
    }
}
