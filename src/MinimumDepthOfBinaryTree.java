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
//iterative
public class MinimumDepthOfBinaryTree{
    public int minDepth(TreeNode root) {
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
                if(cur.left==null && cur.right==null) return depth;
                if(cur.left !=null ) q.add(cur.left);
                if(cur.right !=null ) q.add(cur.right);
            }
        }
        return depth;

    }
}

//recursive
public class MinimumDepthOfBinaryTree{
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int ld = minDepth(root.left), rd = minDepth(root.right);
        if(ld ==0 || rd ==0) return ld+rd+1;
        return Math.min(ld, rd)+1;
    }
}