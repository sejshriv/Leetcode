/*
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:
Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:
Input: n = 33
Output: 66045
 
Constraints:
1 <= n <= 50 

*/

class Solution {
    public int countVowelStrings(int n) {
        // Initialize an array to store counts for strings ending with each vowel
        int[] dp = new int[5];
        // Initialize counts to 1 for each vowel because for n=1, each vowel forms a single-character string
        Arrays.fill(dp, 1);

        // Iterate from n=2 to the target length n
        for (int i = 2; i <= n; ++i) {
            // Iterate through each vowel ending
            for (int j = 1; j < 5; ++j) {
                // Update the count of strings ending with the current vowel
                // by adding the count of strings ending with vowels before it (including itself)
                dp[j] += dp[j - 1];
            }
        }

        // Sum up the counts for all vowels
        int sum = 0;
        for (int count : dp) {
            sum += count;
        }
        return sum;
    }
}
