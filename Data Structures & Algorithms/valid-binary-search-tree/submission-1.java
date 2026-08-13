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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return traverse(root, Integer.MIN_VALUE) != null;
    }

    private Integer traverse(TreeNode root, Integer prev){
        if(root == null){
            return prev;
        }

        prev = traverse(root.left, prev);
        
        if(prev == null || prev >= root.val) return null;

        return traverse(root.right, root.val);
    }
}