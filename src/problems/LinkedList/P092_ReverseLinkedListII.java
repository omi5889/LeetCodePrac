package problems.LinkedList;

/**
 * Created by omkar on 3/16/19.
 *
 *
 Reverse a linked list from position m to n. Do it in one-pass.
 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:

 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL

 Explanation:
 The solution is similar to reverse of linked list. In this case only a part ot it is reversed. So we need to store
 two pointers.
 1] Pointer to m-1 th node to join result after reverse.
 2] Pointer to mth node to join the  list after n th node.


 */
public class P092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode startNode = curr;

        // Reverse linked list from m th node n th node
        for(int i = 0; i < (n-m+1); i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Point next of pre to result of reverse
        pre.next = prev;

        // Point next of startNode to the remaining list
        startNode.next = next;
        return dummy.next;
    }

    public static void main(String[] args) {
        P092_ReverseLinkedListII obj = new P092_ReverseLinkedListII();
        ListNode lnObj = new ListNode();
        ListNode h1 = lnObj.getList(new int[]{1,2,3,4,5,6,7,8,9});
        int m = 4;
        int n = 7;
        ListNode res = obj.reverseBetween(h1,m,n);
        lnObj.dispList(res);
    }
}
