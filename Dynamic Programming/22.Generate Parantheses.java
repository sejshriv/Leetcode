/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 
Constraints:
1 <= n <= 8


*/

class Solution { 
    public static void dfs(List<String> list,int size,String perm,int open,int close){
        if(perm.length()==size*2){
            list.add(perm);
            return;
        }
        if(open<size)
            dfs(list,size,perm+"(",open+1,close);
        if(close<open)
            dfs(list,size,perm+")",open,close+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list,n,"",0,0);
        return list;
    }
}
