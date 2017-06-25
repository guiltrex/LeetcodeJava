//O(n) time complexity and O(1) space
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
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next ==null) return true;
        ListNode h1 = head, h2=h1;
        while(h2!=null && h2.next!=null){
            h1=h1.next;
            h2=h2.next.next;
        }
        h2 = reverse(h1);
        h1 = head;
        for(;h1!=null && h2!=null;h2 = h2.next, h1=h1.next){
            if(h1.val != h2.val) return false;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
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