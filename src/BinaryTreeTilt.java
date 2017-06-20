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
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] res = calSubTree(root);
        return res[0];
    }

    //arr[0] is tiltSum, arr[1] is valSum
    private int[] calSubTree(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int[] leftSubRes = calSubTree(root.left);
        int[] rightSubRes = calSubTree(root.right);
        int tiltSum = leftSubRes[0]+rightSubRes[0]+Math.abs(leftSubRes[1]-rightSubRes[1]);
        int valSum = leftSubRes[1]+rightSubRes[1]+root.val;
        return new int[]{tiltSum, valSum};
    }
}