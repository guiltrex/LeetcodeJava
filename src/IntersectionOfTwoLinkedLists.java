/**
 * Created by jniu on 6/25/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA, pb=headB;
        while(pa!=pb && pa!=null && pb!=null){
            pa=pa.next;
            pb=pb.next;
            if(pa == null && pb!=null) pa = headB;
            if(pb == null && pa!=null) pb = headA;
        }
        return pa==null?pa:pb;
    }
}

private class IntersectionOfTwoLinkedLists1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA, pb=headB;
        boolean fa=false, fb=false;
        while(pa!=null && pb!=null){
            if(pa == pb) return pa;
            if(pa.next == null && fa==false) {
                pa = headB;
                fa=true;
            } else {
                pa = pa.next;
            }
            if(pb.next == null && fb==false) {
                pb = headA;
                fb=true;
            } else {
                pb = pb.next;
            }
        }
        return null;
    }
}

private class IntersectionOfTwoLinkedLists2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        ListNode pa=headA, pb=headB;
        while(pa!=pb){
            if(pa == null) {
                pa = headB;
            } else pa = pa.next;
            if(pb == null) {
                pb = headA;
            }else pb = pb.next;
        }
        return pa;
    }
}