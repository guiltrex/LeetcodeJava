/**
 * Created by jniu on 6/29/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode end = dummy;
        for(ListNode cur = dummy, curNext = cur.next; cur.next!=null;cur=curNext, curNext=curNext.next){
            if(cur.val != curNext.val && (curNext.next==null || curNext.val != curNext.next.val)){
                end.next = curNext;
                end = end.next;
            }
        }
        end.next = null;
        return dummy.next;
    }
}