//May add another DFS solution in the future
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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int qs = q.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i<qs; i++){
                TreeNode node = q.remove();
                tmp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}