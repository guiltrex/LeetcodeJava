/**
 * Created by jniu on 7/10/17.
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
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        int depth = 0, levelSize;
        TreeNode cur = null;
        while(!q.isEmpty()){
            levelSize = q.size();
            depth++;
            for(int i = 0; i<levelSize; i++){
                cur = q.remove();
                if(cur.left !=null ) q.add(cur.left);
                if(cur.right !=null ) q.add(cur.right);
            }
        }
        return depth;
    }
}