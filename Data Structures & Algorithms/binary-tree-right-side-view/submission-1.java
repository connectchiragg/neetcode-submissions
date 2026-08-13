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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        q.add(root);
        result.add(root.val);

        while(!q.isEmpty()){
            List<TreeNode> level = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                if(curr.right != null){
                    level.add(curr.right);
                }
                if(curr.left != null){
                    level.add(curr.left);
                }
            }

            if(level.isEmpty()) break;
            result.add(level.get(0).val);
            q.addAll(level);
        }

        return result;
    }
}
