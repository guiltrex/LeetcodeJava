/**
 * Created by jniu on 7/4/17.
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
//

//Recursive way, 38.45
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        SubTreeMeta tm = helper(root);
        return tm.isBst;
    }

    private SubTreeMeta helper(TreeNode root){
        SubTreeMeta sub, tree = new SubTreeMeta(false, root.val, root.val);
        int max = root.val, min=root.val;
        if(root.left != null){
            if(root.left.val >= root.val) return tree;
            sub = helper(root.left);
            if(!sub.isBst || sub.max >= root.val) return tree;
            min = sub.min;
        }
        if(root.right != null){
            if(root.right.val <= root.val) return tree;
            sub = helper(root.right);
            if(!sub.isBst || sub.min <= root.val) return tree;
            max = sub.max;
        }
        tree.isBst = true;
        tree.max = max;
        tree.min = min;
        return tree;
    }

    private class SubTreeMeta {
        int min;
        int max;
        boolean isBst;
        SubTreeMeta(boolean b, int i, int j){
            max = i;
            min = j;
            isBst = b;
        }
    }
}