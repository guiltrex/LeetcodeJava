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
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}

//Iterative using stack
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root!=null) dq.push(root);
        while(!dq.isEmpty()){
            TreeNode cur = dq.pop();
            list.add(cur.val);
            if(cur.right != null) dq.push(cur.right);
            if(cur.left != null) dq.push(cur.left);
        }
        return list;
    }
}