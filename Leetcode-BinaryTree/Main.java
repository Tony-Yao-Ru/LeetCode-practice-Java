class Main {
    public static void main(String[] args) {
        int[] root = { 3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7 };
        TreeNode binTree = null;
        binTree = buildupTree(0, root, binTree);
        for (int i = 1; i < root.length; i++) {
            buildupTree(i, root, binTree);
        }
        System.out.println(binTree.val + " ");
        System.out.println(BinaryTreeUtil.MaxDepth(binTree));
    }

    private static TreeNode buildupTree(int index, int[] nums, TreeNode temp) {
        TreeNode newnode = TreeNode.newNode(nums[index]);

        TreeNode x = temp;
        TreeNode y = null;

        while (x != null) {
            y = x;
            if (index % 2 == 1) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            y = newnode;
        } else if (index % 2 == 1) {
            y.left = newnode;
        } else {
            y.right = newnode;
        }
        return y;
    }
}