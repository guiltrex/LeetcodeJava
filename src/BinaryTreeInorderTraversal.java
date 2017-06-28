/**
 * Created by jniu on 6/27/17.
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
//Recursive
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> leftSub = inorderTraversal(root.left);
        leftSub.add(root.val);
        List<Integer> rightSub = inorderTraversal(root.right);
        leftSub.addAll(rightSub);
        return leftSub;
    }
}


//Iterative using stack without set
public class BinaryTreeInorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            dq.push(cur);
            cur = cur.left;
        }
        while(!dq.isEmpty()){
            cur = dq.pop();
            res.add(cur.val);
            cur = cur.right;
            while(cur!=null){
                dq.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

}