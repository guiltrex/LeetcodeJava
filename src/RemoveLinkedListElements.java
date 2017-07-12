/**
 * Created by jniu on 7/10/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head, sentinel = new ListNode(0), prev=sentinel;
        sentinel.next = head;
        while(cur!=null){
            if(cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}