/**
 * Created by jniu on 6/23/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode h=head, t=h, cur=t.next;
        while(cur!=null){
            t.next = cur.next;
            cur.next = h;
            h = cur;
            cur = t.next;
        }
        return h;
    }
}