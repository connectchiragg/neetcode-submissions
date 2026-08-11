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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) == -1 ? false : true;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int mdLeft = maxDepth(root.left);
        int mdRight = maxDepth(root.right);

        if(mdLeft == -1 || mdRight == -1 || Math.abs(mdLeft - mdRight) > 1){
            return -1;
        }

        return 1 + Math.max(mdLeft, mdRight);
    }
}
