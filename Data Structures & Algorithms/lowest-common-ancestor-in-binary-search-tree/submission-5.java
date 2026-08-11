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
        return impl(root, List.of(p, q)).lca;
    }

    private Result impl(TreeNode root, List<TreeNode> nodes){
        int n = nodes.size();

        if(root == null) return new Result(n);

        Result left = new Result(n);
        Result right = new Result(n);

        for(TreeNode node : nodes){
            if(node.val < root.val){
                left = impl(root.left, nodes);
                break;
            }
        }

        for(TreeNode node : nodes){
            if(node.val > root.val){
                right = impl(root.right, nodes);
                break;
            }
        }

        if(left.lca != null) return left;
        if(right.lca != null) return right;

        Result result = new Result(n);

        for(int i = 0; i < n; i++){
            result.matches.set(i, 
            root.val == nodes.get(i).val || left.matches.get(i) || right.matches.get(i));
        }

        result.lca = result.matches.contains(false) ? null : root;

        return result;
    }
}
