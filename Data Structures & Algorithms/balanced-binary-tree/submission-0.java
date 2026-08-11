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
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        result = true;
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int mdLeft = maxDepth(root.left);
        int mdRight = maxDepth(root.right);

        if(Math.abs(mdLeft - mdRight) > 1) result = false;
        return 1 + Math.max(mdLeft, mdRight);
    }
}
