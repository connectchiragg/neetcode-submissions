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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode lcaLeft = lowestCommonAncestor(root.left, p, q);
        if(lcaLeft != null) return lcaLeft;

        TreeNode lcaRight = lowestCommonAncestor(root.right, p, q);
        if(lcaRight != null) return lcaRight;

        if(search(root, p) && search(root, q)){
            return root;
        }

        return null;
    }

    private boolean search(TreeNode root, TreeNode p){
        if(p == null) return true;
        if(root == null) return false;
        return root == p || search(root.left, p) || search(root.right, p);
    }
}
