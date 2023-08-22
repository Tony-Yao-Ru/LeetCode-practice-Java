public class BinaryTreeUtil {
    static public int MaxDepth(TreeNode root) {
        // Give the condition for the termination of the recursion
        if (root == null) {
            return 0;
        }

        // Give the logic of calling the recursion
        return 1 + Math.max(MaxDepth(root.left), MaxDepth(root.right));

        // Give the return result after executing the recursion
        // Here we don't need it
    }
}