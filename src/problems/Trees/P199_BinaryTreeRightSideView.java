package problems.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by omkar on 3/26/19.
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 Input: [1,2,3,null,5,null,4]
 Output: [1, 3, 4]

 *
 *
 */
public class P199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            int k = queue.size();
            for(int i=0; i<k; i++) {
                TreeNode curr = queue.poll();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
                temp.add(curr.val);
            }
            if(temp.size()>0) res.add(temp.get(temp.size()-1));
        }
        return res;
    }


    public List<TreeNode> getTestCases(){
        List<TreeNode> list = new ArrayList<>();
        TreeNode tobj = new TreeNode(0);
        TreeNode h1 = tobj.getTree("1,2,3");
        list.add(h1);
        String str = tobj.dispTree(h1);
//        String str = tobj.serialize(h1).toString();
        System.out.println(str);
        return list;
    }

    public static void main(String[] args){
        P199_BinaryTreeRightSideView obj = new P199_BinaryTreeRightSideView();
        List<TreeNode> testcases = obj.getTestCases();
//        for(TreeNode testcase: testcases) {
//            System.out.println("res:: "+obj.rightSideView(testcase));
//        }
    }

}
