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
public class MergeTwoSortedLists{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=null, h1=null, h2=null, cur=null;
        if(l1!=null && l2!=null) {
            if(l1.val<=l2.val){
                head=l1;
                h1=l1.next;
                h2=l2;
            } else {
                head=l2;
                h1=l1;
                h2 = l2.next;
            }
            cur = head;
        }
        while(h1!=null && h2!=null){
            if(h1.val <= h2.val){
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if(h1 == null){
            cur.next = h2;
        }
        if(h2 == null){
            cur.next = h1;
        }
        return head;

    }
}


private class MergeTwoSortedLists2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=new ListNode(0), h1=l1, h2=l2, cur = head;
        while(h1!=null && h2!=null){
            if(h1.val <= h2.val){
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if(h1 == null){
            cur.next = h2;
        }
        if(h2 == null){
            cur.next = h1;
        }
        return head.next;
    }
}