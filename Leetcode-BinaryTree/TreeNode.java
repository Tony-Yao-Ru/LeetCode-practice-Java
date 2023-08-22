public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {
    // }

    // TreeNode(int val) {
    // this.val = val;
    // }

    // TreeNode(int val, TreeNode left, TreeNode right) {
    // this.val = val;
    // this.left = left;
    // this.right = right;
    // }

    static public TreeNode newNode(int data) {
        TreeNode temp = new TreeNode();
        temp.val = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }
}