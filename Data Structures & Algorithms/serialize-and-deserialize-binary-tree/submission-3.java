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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        preorder(root, s);
        System.out.println(s.toString());
        return s.toString();
    }

    private void preorder(TreeNode root, StringBuilder s){
        if(s.length() != 0){
            s.append(",");
        }

        if(root == null){
            s.append("null");
            return;
        }

        s.append(root.val);

        preorder(root.left, s);
        preorder(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preorder = data.split(",");

        if(preorder.length == 0) return null;
        Stack<String> stack = new Stack<>();

        for(int i = preorder.length - 1; i >= 0; i--){
            stack.add(preorder[i]);
        }

        return build(stack);
    }

    private TreeNode build(Stack<String> stack){
        if(stack.isEmpty()){
            return null;
        }

        if(stack.peek().equals("null")){
            stack.pop();
            return null;
        }

        return new TreeNode(
            Integer.parseInt(stack.pop()),
            build(stack),
            build(stack)
        );
    }
}
