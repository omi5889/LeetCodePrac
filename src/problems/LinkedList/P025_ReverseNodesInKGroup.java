package problems.LinkedList;

/**
 * Created by omkar on 3/5/19.
 */
public class P025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null || head.next==null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        ListNode tail = head;
        for(int i=1;i<k;i++){
            tail = tail.next;
            if(tail==null)
                return head;
        }
        while(count<k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null)
            head.next=reverseKGroup(next,k);
        return prev;
    }
    public static void main(String[] args){
        P025_ReverseNodesInKGroup obj = new P025_ReverseNodesInKGroup();
        ListNode l1 = new ListNode();
        ListNode h1 = l1.getList(new int[]{19,48,57,46,11,43,12,55,97,82,31});
        int k = 3;
        ListNode res = obj.reverseKGroup(h1,k);
        while(res!=null) {
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
