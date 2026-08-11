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
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        result = Math.max(result, maxDepthLeft + maxDepthRight);
        return 1 + Math.max(maxDepthLeft, maxDepthRight);
    }
}

