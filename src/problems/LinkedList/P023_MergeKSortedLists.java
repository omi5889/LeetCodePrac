package problems.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by omkar on 1/25/19.
 */
public class P023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        for(ListNode list: lists) {
            if(list!=null) queue.offer(list);
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null) queue.offer(tail.next);
        }

        return head.next;
    }


    public static void main(String[] args){
        P023_MergeKSortedLists obj = new P023_MergeKSortedLists();
        ListNode l1 = new ListNode();
        ListNode h1 = l1.getList(new int[]{1,4,5});
        ListNode h2 = l1.getList(new int[]{1,3,4});
        ListNode h3 = l1.getList(new int[]{2,6});
        ListNode[] lists = new ListNode[]{h1,h2,h3};
        ListNode res = obj.mergeKLists(lists);
        while(res!=null) {
            System.out.print(res.val+" ");
            res=res.next;
        }


    }
}
