/**
 * Created by jniu on 6/20/17.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int s = sum - root.val;
        boolean res = false;
        if(root.left != null) res = res || hasPathSum(root.left, s);
        if(!res && root.right != null) res = res || hasPathSum(root.right, s);
        if(root.right == null && root.left == null) return s == 0;
        return res;
    }
}