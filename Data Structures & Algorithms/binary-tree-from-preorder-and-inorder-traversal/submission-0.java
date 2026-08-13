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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, map, 0, 0, n - 1);
    }

    private TreeNode build(int[] pre, Map<Integer, Integer> ino, int start, int curr, int end){
        if(curr < 0 || end >= pre.length || curr > end){
            return null;
        }

        int left = curr + 1;
        int leftEnd = curr + (ino.get(pre[curr]) - start);
        int right = leftEnd + 1;
        int rightEnd = end;

        return new TreeNode(
            pre[curr],
            build(pre, ino, start, left, leftEnd),
            build(pre, ino, ino.get(pre[curr]) + 1, right, rightEnd)
        );
    }
}
