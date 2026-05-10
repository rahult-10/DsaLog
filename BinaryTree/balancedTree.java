public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

private int dfs(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int leftHeight = dfs(root.left);
    if (leftHeight == -1) {
        return -1;
    }
    int rightHeight = dfs(root.right);
    if (rightHeight == -1) {
        return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
        }
    return 1 + Math.max(leftHeight, rightHeight);
}

public boolean balancedTree(TreeNode root) {
    return dfs(root) != -1;
}

public void main(String[] args) {
    
}