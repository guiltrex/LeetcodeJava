/**
 * Created by jniu on 6/26/17.
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
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        if(p == null || q==null) return null;
        if(p.val > root.val && q.val < root.val || p.val<root.val && q.val > root.val) {
            return root;
        } else if(p.val < root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}


public class LowestCommonAncestorOfBinarySearchTree2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null || q==null) return null;
        while(root!=null){
            if(root == p || root == q || p.val > root.val && q.val < root.val || p.val<root.val && q.val > root.val) {
                return root;
            } else if(p.val < root.val && q.val<root.val){
                root=root.left;
            } else {
                root=root.right;
            }
        }
        return root;
    }
}