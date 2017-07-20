/**
 * Created by jniu on 7/14/17.
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
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder ==null || preorder.length != inorder.length) return null;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps>pe || is>ie) return null;
        int rv = preorder[ps];
        int ri = map.get(rv);
        TreeNode root = new TreeNode(rv);
        root.left = helper(preorder, ps+1, ps+ri-is, inorder, is, ri-1);
        root.right = helper(preorder, ps+ri-is+1, pe, inorder, ri+1, ie);
        return root;
    }

    Map<Integer, Integer> map;
}