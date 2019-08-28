package problems.Trees;

import java.util.*;

/**
 * Created by omkar on 1/31/19.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    private static final String spliter = ",";

    TreeNode() {}

    TreeNode(int x) {
        this.val = x;
    }

    TreeNode getTree(String data) {
        List<String> nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        nodes.add(0,"-1");
        return makeTree(nodes,1);
    }

    private TreeNode makeTree(List<String> nodes, int index) {
        if(index > nodes.size()-1 ) return null;
        String val = nodes.get(index);
        if(val.equalsIgnoreCase("null")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = makeTree(nodes,2*index);
            node.right = makeTree(nodes, (2*index)+1);
            return node;
        }
    }

    String dispTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if(node==null) {
            sb.append("null").append(spliter);

        } else {
            sb.append(node.val).append(spliter);
            if(node.left==null && node.right==null) return;
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }

    public static void main(String[] args) {
        TreeNode obj = new TreeNode(0);
        TreeNode h1 = obj.getTree("1,2,3,4,5,6");
        String res = obj.dispTree(h1);
        System.out.print(res);

    }

}
