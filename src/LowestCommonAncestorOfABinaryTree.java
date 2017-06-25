//Do again
/**
 * Created by jniu on 6/24/17.
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
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null || q==null) return null;
        TreeNode[] res = helper(root, p, q);
        if(res!=null && res.length==2){
            return res[1];
        } else{
            return null;
        }
    }

    private TreeNode[] helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null && q==null) return null;

        TreeNode[] lst = helper(root.left, p, q);
        if(lst!=null && lst[1] !=null) return lst;
        TreeNode[] rst = helper(root.right, p, q);
        if(rst!=null && rst[1] !=null ) return rst;

        if(root == p || root == q) {
            if (lst!=null && lst[0]!=null){
                lst[1] = root;
                return lst;
            }
            if (rst!=null && rst[0]!=null){
                rst[1] = root;
                return rst;
            }
            return new TreeNode[]{root,null};
        } else{
            if(lst!=null && rst!=null && rst[0]!=null && lst[0]!=null){
                return new TreeNode[]{lst[0], root};
            } else if (lst!=null && lst[0]!=null){
                return lst;
            } else if (rst!=null && rst[0]!=null){
                return rst;
            } else {
                return null;
            }
        }
    }
}


private class LowestCommonAncestorOfABinaryTree2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root==q) return root;
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA!=null?leftLCA:rightLCA;
    }
}