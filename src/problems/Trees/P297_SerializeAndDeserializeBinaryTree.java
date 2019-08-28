package problems.Trees;

import java.util.*;

/**
 * Created by omkar on 2/4/19.
 */
public class P297_SerializeAndDeserializeBinaryTree {
    static List<Integer> res = new ArrayList<>();
    static List<String> resStr = new ArrayList<>();
    private static final String spliter = ",";
    private static final String NN = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if(node==null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }


    public TreeNode deserialize(String data){
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if(val.equals(NN)) return null;
        else {

            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public void preorder(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        if(root.val==-1)
            resStr.add("null");
        else
            resStr.add(""+root.val);
        preorder(root.left);
        preorder(root.right);

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
        P297_SerializeAndDeserializeBinaryTree obj = new P297_SerializeAndDeserializeBinaryTree();
        int[] arr = {1,2,3,-1,-1,4,5};
        TreeNode root = getTree(arr);
        obj.preorder(root);
//        System.out.println("Preorder:: "+res);
//        res.clear();
//        System.out.println("Preorder str:: "+resStr);
        String str = obj.serialize(root).toString();
        System.out.println(str);
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(str.split(spliter)));
        System.out.println(nodes);



    }
}
