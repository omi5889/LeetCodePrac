package problems.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 1/31/19.
 */
public class TreeTraversal {
    static List<Integer> res = new ArrayList<>();

    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);

    }

    public void preorder(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);

    }

    public void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);

    }



    private static TreeNode getTree(int[] arr) {
        if(arr.length==0) return null;
        if(arr.length==1) return new TreeNode(arr[0]);
        return makeTree(arr,0);
    }

    private static TreeNode makeTree(int[] arr, int i) {
        if(i>=arr.length) return null;
        TreeNode root = new TreeNode(arr[i]);
        int leftIndex = i*2 + 1;
        int rightIndex = i*2 + 2;
        root.left = leftIndex>=arr.length ? null: makeTree(arr,(i*2 + 1));
        root.right = rightIndex>=arr.length ? null:makeTree(arr,(i*2 + 2));
        return root;
    }

    public static void main(String[] args){
        TreeTraversal obj = new TreeTraversal();
        int[] arr = {1,2,3,-1,-1,4,5};
        TreeNode root = getTree(arr);
        System.out.println(root.val);
        obj.inorder(root);
        System.out.println("Inorder:: "+res);
        res.clear();
        obj.preorder(root);
        System.out.println("Preorder:: "+res);
        res.clear();
        obj.postorder(root);
        System.out.println("Postorder:: "+res);
        res.clear();
    }
}
