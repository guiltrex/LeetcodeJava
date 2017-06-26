/**
 * Created by jniu on 6/25/17.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2=head;
        while(p1!=null && p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p2 == p1) return true;
        }
        return false;
    }
}