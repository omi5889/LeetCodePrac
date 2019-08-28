package problems.LinkedList;

/**
 * Created by omkar on 1/25/19.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode() {

    }

    /*
    * creates a new linked from provided array with first element as head
    * input: int array like [6,2,7,9]
    * output: ListNode head 6
    * */
    public ListNode getList(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i=0; i<arr.length;i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head.next;
    }

    public void dispList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head!=null) {
            sb.append(head.val);
            sb.append(" ");
            head = head.next;
        }
        System.out.print(sb.toString());
    }
}
