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
class Result {
    List<Boolean> matches;
    TreeNode lca;

    public Result(List<Boolean> matches, TreeNode lca){
        this.matches = matches;
        this.lca = lca;
    }

    public Result(int num){
        this.matches = new ArrayList<>(Collections.nCopies(num, false));
        this.lca = null;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodes = List.of(p, q);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(TreeNode node : nodes){
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
        }

        return findLca(root, min, max, nodes);
    }

    private TreeNode findLca(TreeNode root, int min, int max, List<TreeNode> nodes){
        if(root == null) return null;
        if(root.val < min) return findLca(root.right, min, max, nodes);
        if(root.val > max) return findLca(root.left, min, max, nodes);
        
        // validate whether root is an LCA to all nodes
        for(TreeNode node : nodes){
            if(node == null) continue;
            if(!search(root, node)) return null;
        }

        return root;
    }

    private boolean search(TreeNode root, TreeNode target){
        if(root == null) return false;
        if(root.val < target.val) return search(root.right, target);
        if(root.val > target.val) return search(root.left, target);
        return root == target;
    }
}