/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    record Result(int k, TreeNode node) {};

    public int kthSmallest(TreeNode root, int k) {
        return solve(root, k).node().val;
    }

    private Result solve(TreeNode root, int k){
        if(root == null){
            return new Result(k, null);
        }

        Result result = solve(root.left, k);

        if(result.node != null) return result;
        if(result.k == 1) return new Result(0, root);

        return solve(root.right, result.k - 1);
    }
}
