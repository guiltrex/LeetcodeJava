/**
 * Created by jniu on 7/12/17.
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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirrorEqual(root.left, root.right);
    }

    private boolean isMirrorEqual(TreeNode n1, TreeNode n2){
        if(n1 == null && n2==null){
            return true;
        } else if (n1!=null && n2!=null && n1.val==n2.val){
            return isMirrorEqual(n1.left, n2.right) && isMirrorEqual(n1.right, n2.left);
        } else {
            return false;
        }
    }
}