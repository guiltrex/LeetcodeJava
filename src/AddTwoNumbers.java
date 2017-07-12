//Do it again with new created node
/**
 * Created by jniu on 7/4/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 75%
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode p1=l1, p2=l2, pl1=p1;
        while(p1!=null && p2!=null){
            p1.val = p1.val + p2.val + carry;
            carry = p1.val/10;
            p1.val = p1.val % 10;
            pl1 = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p2!=null){
            pl1.next = p2;
            p1 = pl1.next;
        }
        while(p1!=null && carry != 0){
            p1.val = p1.val + carry;
            carry = p1.val/10;
            p1.val = p1.val%10;
            pl1 = p1;
            p1 = p1.next;
        }
        if(carry==1) {
            pl1.next = new ListNode(1);
            pl1.next.next = null;
        }
        return l1;
    }
}