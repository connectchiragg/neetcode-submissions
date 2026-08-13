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
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }

    private int solve(TreeNode root, int max){
        if(root == null) return 0;

        int curr = 0; // decides whether to count this as a good node

        if(root.val >= max){
            curr = 1;
            max = root.val;
        }

        return curr + solve(root.left, max) + solve(root.right, max);
    }
}
