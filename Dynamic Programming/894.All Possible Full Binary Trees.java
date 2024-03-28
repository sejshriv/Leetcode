/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Example 1:
Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

Example 2:
Input: n = 3
Output: [[0,0,0]]
 
Constraints:
1 <= n <= 20

*/

class Solution {
  public List<TreeNode> allPossibleFBT(int n) {
    if (n % 2 == 0)
      return new ArrayList<>();
    if (n == 1)
      return Arrays.asList(new TreeNode(0));
    if (mem.containsKey(n))
      return mem.get(n);

    List<TreeNode> ans = new ArrayList<>();

    for (int leftCount = 0; leftCount < n; ++leftCount) {
      final int rightCount = n - 1 - leftCount;
      for (TreeNode left : allPossibleFBT(leftCount))
        for (TreeNode right : allPossibleFBT(rightCount)) {
          ans.add(new TreeNode(0));
          ans.get(ans.size() - 1).left = left;
          ans.get(ans.size() - 1).right = right;
        }
    }

    mem.put(n, ans);
    return ans;
  }

  private Map<Integer, List<TreeNode>> mem = new HashMap<>();
}
