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

        TreeNode possibleLca = findPossibleLca(root, min, max);
        return impl(possibleLca, nodes, min, max).lca;
    }

    private TreeNode findPossibleLca(TreeNode root, int min, int max){
        if(root == null) return null;
        if(root.val < min) return findPossibleLca(root.right, min, max);
        if(root.val > max) return findPossibleLca(root.left, min, max);
        return root;
    }

    private Result impl(TreeNode root, List<TreeNode> nodes, int min, int max){
        int n = nodes.size();

        if(root == null) return new Result(n);

        Result left = new Result(n);
        Result right = new Result(n);

        if(min < root.val){
            left = impl(root.left, nodes, min, max);
        }
        
        if(max > root.val){
            right = impl(root.right, nodes, min, max);
        }

        if(left.lca != null) return left;
        if(right.lca != null) return right;

        Result result = new Result(n);

        for(int i = 0; i < n; i++){
            result.matches.set(i, 
            root == nodes.get(i) || left.matches.get(i) || right.matches.get(i));
        }

        result.lca = result.matches.contains(false) ? null : root;

        return result;
    }
}
