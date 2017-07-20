//Do again using iterative approach
/**
 * Created by jniu on 7/13/17.
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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length==0 || postorder.length ==0 || inorder.length != postorder.length) return null;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postStart, int postEnd){
        if(inorderStart > inorderEnd || postStart > postEnd) return null;

        int rv = postorder[postEnd];
        TreeNode root = new TreeNode(rv);
        int rootIndex = map.get(rv);

        TreeNode leftSub = helper(inorder, postorder, inorderStart, rootIndex-1, postStart, postStart+rootIndex-inorderStart-1);
        TreeNode rightSub = helper(inorder, postorder, rootIndex+1, inorderEnd, postStart+rootIndex-inorderStart, postEnd-1);

        root.left = leftSub;
        root.right = rightSub;
        return root;
    }

    Map<Integer, Integer> map;
}