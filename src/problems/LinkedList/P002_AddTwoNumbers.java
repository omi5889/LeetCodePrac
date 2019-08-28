package problems.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 4/8/19.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 *
 *
 *
 */
public class P002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        if(l1==null && l2==null) return head;
        if(l1==null && l2!=null) return l2;
        if(l1!=null && l2==null) return l1;
        ListNode res = head;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0) {

            int s1 = (l1==null) ? 0 : l1.val;
            int s2 = (l2==null) ? 0 : l2.val;
            int sum = s1+s2+carry;
            ListNode temp = new ListNode(sum%10);
            carry = (sum>9) ? 1 : 0;

            res.next = temp;
            res = res.next;
            l1 = (l1!=null) ? l1.next : l1;
            l2 = (l2!=null) ? l2.next : l2;

        }

        return head.next;
    }

    public List<ListNode[]> getTestCases() {
        List<ListNode[]> list = new ArrayList<>();
        ListNode l1 = new ListNode(0);
        ListNode[] arr1 = new ListNode[]{l1.getList(new int[]{1,2,3}), l1.getList(new int[]{1,2,3})};
        ListNode[] arr2 = new ListNode[]{l1.getList(new int[]{1}), l1.getList(new int[]{1,2,3})};
        ListNode[] arr3 = new ListNode[]{l1.getList(new int[]{9}), l1.getList(new int[]{9})};
        ListNode[] arr4 = new ListNode[]{l1.getList(new int[]{}), l1.getList(new int[]{})};
        ListNode[] arr5 = new ListNode[]{l1.getList(new int[]{2,4,3}), l1.getList(new int[]{5,6,4})};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        return list;
    }

    public static void main(String[] args) {
        P002_AddTwoNumbers obj = new P002_AddTwoNumbers();
        List<ListNode[]> testCases = obj.getTestCases();
        ListNode l1 = new ListNode(0);
        for(ListNode[] testCaseArr : testCases) {
            ListNode res = obj.addTwoNumbers(testCaseArr[0],testCaseArr[1]);
            System.out.print("res: ");
            l1.dispList(res);
            System.out.println();
        }

    }
}
