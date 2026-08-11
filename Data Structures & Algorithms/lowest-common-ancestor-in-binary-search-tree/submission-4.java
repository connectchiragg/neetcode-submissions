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
    boolean p;
    boolean q;
    TreeNode lca;

    public Result(boolean p, boolean q, TreeNode lca){
        this.p = p;
        this.q = q;
        this.lca = lca;
    }

    public Result(){
        this.p = false;
        this.q = false;
        this.lca = null;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return impl(root, p, q).lca;
    }

    private Result impl(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new Result();

        Result left = new Result();
        Result right = new Result();

        if(root.val > p.val || root.val > q.val){
            left = impl(root.left, p, q);
        }

        if(root.val < p.val || root.val < q.val){
            right = impl(root.right, p, q);
        }

        if(left.lca != null) return left;
        if(right.lca != null) return right;

        Result result = new Result();

        result.p = root == p || left.p || right.p;
        result.q = root == q || left.q || right.q;
        result.lca = (result.p && result.q) ? root : null;

        return result;
    }
}
