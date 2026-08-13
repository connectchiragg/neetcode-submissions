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

    private TreeNode build(int[] pre, Map<Integer, Integer> ino, int inorderStart, int curr, int end){
        if(curr < 0 || end >= pre.length || curr > end){
            return null;
        }

        int inorderIdx = ino.get(pre[curr]);

        int left = curr + 1;
        int leftEnd = curr + (inorderIdx - inorderStart);
        int right = leftEnd + 1;
        int rightEnd = end;

        return new TreeNode(
            pre[curr],
            build(pre, ino, inorderStart, left, leftEnd),
            build(pre, ino, inorderIdx + 1, right, rightEnd)
        );
    }
}
