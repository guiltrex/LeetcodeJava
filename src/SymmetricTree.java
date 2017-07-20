/**
 * Created by jniu on 7/12/17.
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
//recursive
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirrorEqual(root.left, root.right);
    }

    private boolean isMirrorEqual(TreeNode n1, TreeNode n2){
        if(n1 == null && n2==null){
            return true;
        } else if (n1!=null && n2!=null && n1.val==n2.val){
            return isMirrorEqual(n1.left, n2.right) && isMirrorEqual(n1.right, n2.left);
        } else {
            return false;
        }
    }
}

//Iterative using LinkedList (with null supported) 13%
public class SymmetricTree2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        TreeNode n1, n2;
        while(!q.isEmpty()){
            n1=q.remove();
            n2=q.remove();
            if(n1==null && n2==null) continue;
            if(n1==null || n2== null) return false;
            if(n1.val!=n2.val) return false;
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}

//Iterative using queue 6%
public class SymmetricTree3 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        int size;

        while(!q.isEmpty()){
            size = q.size();
            TreeNode[] ns = new TreeNode[size * 2];
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                ns[2*i] = node.left;
                ns[2*i+1] = node.right;
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            if(!arraySym(ns)) return false;
        }
        return true;
    }

    private boolean arraySym(TreeNode[] arr){
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            if(arr[i]!=null && arr[j]==null || arr[i]==null && arr[j]!=null || arr[i]!=null && arr[j]!=null && arr[i].val !=arr[j].val) return false;
        }
        return true;
    }

}