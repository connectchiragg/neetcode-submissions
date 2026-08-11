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
        List<TreeNode> nodes = List.of(p, q);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(TreeNode node : nodes){
            if(node == null) continue;
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
        }

        if(min == Integer.MAX_VALUE){
            return null;
        }

        return findLca(root, min, max, nodes);
    }

    private TreeNode findLca(TreeNode root, int min, int max, List<TreeNode> nodes){
        while(root != null){
            if(root.val < min){
                root = root.right;
            } else if(root.val > max){
                root = root.left;
            } else {
                break;
            }
        }

        if(root == null) return null;

        // validate whether root is an LCA to all nodes
        for(TreeNode node : nodes){
            if(node == null) continue;
            if(!search(root, node)) return null;
        }

        return root;
    }

    private boolean search(TreeNode root, TreeNode target){
        while(root != null){
            if(root.val < target.val){
                root = root.right;
            } else if(root.val > target.val){
                root = root.left;
            } else {
                break;
            }
        }

        return root != null && root == target;
    }
}