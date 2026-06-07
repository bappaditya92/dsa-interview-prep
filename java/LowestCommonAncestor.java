class TreeNode {

    int data;

    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class LowestCommonAncestor {

    public static TreeNode lca(
            TreeNode root,
            int n1,
            int n2) {

        if(root == null) {
            return null;
        }

        if(root.data == n1 ||
           root.data == n2) {

            return root;
        }

        TreeNode left =
                lca(root.left, n1, n2);

        TreeNode right =
                lca(root.right, n1, n2);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
