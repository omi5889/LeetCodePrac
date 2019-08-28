package problems.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by omkar on 4/8/19.
 *
 * Find the sum of all left leaves in a given binary tree.
 * input: [3,9,20,null,null,15,7]
 * output: 24
 *
 */
public class P404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left!=null) {
                if(curr.left.left==null && curr.left.right==null) {
                    res += curr.left.val;
                } else {
                    queue.offer(curr.left);
                }
            }
            if(curr.right!=null) queue.offer(curr.right);
        }
        return res;
    }

    public List<TreeNode> getTestCases() {
        List<TreeNode> list = new ArrayList<>();
        TreeNode treeObj = new TreeNode();
        list.add(treeObj.getTree("2,3,4,5"));
        list.add(treeObj.getTree("3,9,20,null,null,15,7"));
        return list;
    }

    public static void main(String[] args){
        P404_SumOfLeftLeaves obj = new P404_SumOfLeftLeaves();

        List<TreeNode> testCases = obj.getTestCases();
        for(TreeNode testcase : testCases) {
            int res = obj.sumOfLeftLeaves(testcase);
            System.out.println("res = "+ res);
        }
    }
}
