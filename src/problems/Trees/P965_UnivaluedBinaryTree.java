package problems.Trees;

/**
 * Created by omkar on 5/2/19.
 */
public class P965_UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        int left = (root.left==null) ? root.val : root.left.val;
        int right = (root.right==null) ? root.val : root.right.val;
        boolean curr = (root.val==left) && (root.val==right) ;
        return curr && isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        P965_UnivaluedBinaryTree obj = new P965_UnivaluedBinaryTree();
        TreeNode tobj = new TreeNode(0);
        TreeNode root = tobj.getTree("");
        boolean res = obj.isUnivalTree(root);
        System.out.println(res);
    }
}
